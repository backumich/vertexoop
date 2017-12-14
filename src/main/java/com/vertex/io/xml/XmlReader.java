package com.vertex.io.xml;

import com.vertex.io.UserReader;
import com.vertex.io.vo.IoUser;
import com.vertex.io.vo.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlReader implements UserReader {

    public List<IoUser> readUsers(File xmlFile) {
        Users result = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            result = (Users) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return result.getUsers();
    }

    public void writeUsers(File xmlFile, Users users) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(users, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Users users = getUsers();

        XmlReader xmlReader = new XmlReader();
        File xmlFile = new File("./src/main/resources/users.xml");
        xmlFile.createNewFile();
        xmlReader.writeUsers(xmlFile, users);

        List<IoUser> usersFromXml = xmlReader.readUsers(xmlFile);

        System.out.println(usersFromXml);
    }

    public static Users getUsers() {
        return new Users(Arrays.asList(
                new IoUser(1L, "Kolia"),
                new IoUser(2L, "Tolia"),
                new IoUser(3L, "Polia")));
    }
}
