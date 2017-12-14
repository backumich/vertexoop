package com.vertex.io.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vertex.io.UserReader;
import com.vertex.io.vo.IoUser;
import com.vertex.io.vo.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static com.vertex.io.xml.XmlReader.getUsers;

/**
 * Created by sweet_home on 23.10.16.
 */
public class JsonUserReader implements UserReader {


    public List<IoUser> readUsers(File jsonFile) {
        List<IoUser> result = null;
        Gson gson = new GsonBuilder()
                .setDateFormat("dd-MMM-yyyy")
                .setPrettyPrinting()
                .create();

        try {
            String json = new String(Files.readAllBytes(jsonFile.toPath()));

            System.out.println(json);

            Users users = gson.fromJson(json, Users.class);
            result = users.getUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeUsers(File jsonFile, Users users) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String jsonUsers = gson.toJson(users);

        System.out.println(jsonUsers);

        try (FileWriter fileWriter = new FileWriter(jsonFile)) {
            fileWriter.write(jsonUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Users users = getUsers();

        JsonUserReader reader = new JsonUserReader();
        File jsonFile = new File("users.json");
        reader.writeUsers(jsonFile, users);

        List<IoUser> usersFromJson = reader.readUsers(jsonFile);
        System.out.println(usersFromJson);
    }
}
