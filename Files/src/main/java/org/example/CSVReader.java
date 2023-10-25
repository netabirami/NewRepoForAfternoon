package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {
    public static void main(String[] args) {

        String fileName ="/Users/abirami/IdeaProjects/Testproject/NewRepoForAfternoon/Files/src/main/resources/user_data.csv";

        try (BufferedReader reader= new BufferedReader(new FileReader(fileName))){
            String line;

            while ((line = reader.readLine())!=null){
                String[] data = line.split(",");
                    String name = data[0].trim();
                    int age = Integer.parseInt(data[1].trim());
                    String email = data[2].trim();
                    String phoneNumber = data[3].trim();
                    String address = data[4].trim();

                    System.out.println("Name :"+ name);
                    System.out.println("Age :"+age);
                    System.out.println("Email :"+email);
                    System.out.println("Phone Number:"+phoneNumber);
                    System.out.println("Address :"+address);
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
