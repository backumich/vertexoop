package com.vertex.io.readwrite;

import java.io.*;
import java.nio.file.Files;

public class IoStreamsExamples {

    public static void main(String[] args) {
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream("./src/main/resources/streamsExample.txt");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fileInputStream != null) {
//                try {
//                    fileInputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        StringBuilder builder = new StringBuilder();
        try (FileInputStream inputStream = new FileInputStream("./src/main/resources/streamsExample.txt");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n");
            }

            System.out.println(builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }




        try(FileOutputStream fileOutputStream = new FileOutputStream("./src/main/resources/streamsExampleOut.txt")) {
            fileOutputStream.write(builder.toString().getBytes());
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
