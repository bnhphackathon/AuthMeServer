package com.poalim.hackathon.authme.service;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FileCrudService {
//    public static void main(String[] args) {
//        int userId = 12345; // example user ID
//
//        insertIntoDB(userId, jwt);
//
//        String userIdToFind = "12345"; // example user ID to find
//        String token = readFromDB(userIdToFind);
//        if (token != null) {
//            System.out.println("Token for user ID " + userIdToFind + ": " + token);
//        }
//    }

    public  void insertIntoDB(String userId, String jwt){
        String fileName = "c:\\temp\\AuthMe.csv";
        String fileNameNew = "c:\\temp\\AuthNewMe.csv";

        try {
                File file = new File(fileName);
            File fileNew = new File(fileNameNew);
            FileWriter writer = new FileWriter(fileNew, true);


            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder stringBuilder = new StringBuilder();
                boolean userIdFound = false;

                while ((line = reader.readLine()) != null) {
                    String[] tokens = line.split(",");
                    if (tokens.length > 0 && tokens[0].equals(userId)) {
                        userIdFound = true;
                    } else {
                        stringBuilder.append(line + "\r\n");
                    }
                }

                if (userIdFound) {
                    writer.write(stringBuilder.toString());
                } else {
                    writer.append(userId + "," + jwt + "\r\n");
                }


            } else {
                fileNew.createNewFile();
                writer.append("UserId,Token\r\n" + userId + "," + jwt + "\r\n");
            }

            writer.flush();
            writer.close();
            Path filePath = Path.of(fileName);
            Path newFilePath = Path.of(fileNameNew);
            Files.delete(filePath);
            Files.move(filePath, newFilePath);
            System.out.println("User ID " + userId + " has been inserted into the database.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String readFromDB(String UserIDToFind) {
        String fileName = "c:\\temp\\AuthMe.csv";

        try {
            File file = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length > 0 && tokens[0].equals(UserIDToFind)) {
                    reader.close();
                    return tokens[1];
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("UserID not registered");
        return null;
    }
}


