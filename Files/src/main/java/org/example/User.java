package org.example;

import org.jetbrains.annotations.Contract;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String name;
    private int age;
    private String email;



    private String phoNumber;
    private String address;
    public String getPhoNumber() {
        return phoNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoNumber(String phoNumber) {
        this.phoNumber = phoNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueAddingUsers = true;

        while (continueAddingUsers) {
            // Prompt the user for user data (name, age, email, phone number, address)
            System.out.println("Enter user data:");

            // Collect user data and create a User object
            User user = new User();

            System.out.print("Name: ");
            user.setName(scanner.nextLine());

            System.out.print("Age: ");
            user.setAge((scanner.nextInt()));
            scanner.nextLine();

            System.out.print("Email: ");
            user.setEmail(scanner.nextLine());


            System.out.print("Phone Number: ");
            user.setPhoNumber(scanner.nextLine());

            System.out.print("Address: ");
            user.setAddress(scanner.nextLine());

            // Add the User object to the list
            users.add(user);

            // Ask the user if they want to add more users
            System.out.print("Add another user (yes/no)? ");
            String response = scanner.nextLine();
            continueAddingUsers = response.equalsIgnoreCase("yes");

            try (FileWriter writer = new FileWriter("/Users/abirami/IdeaProjects/Testproject/NewRepoForAfternoon/Files/src/main/resources/user_data.csv")) {
                for (User userparam : users) {
                    String userData = String.format(
                            "%s,%d,%s,%s,%s,%n",
                            userparam.getName(), userparam.getAge(), userparam.getEmail(), userparam.getPhoNumber(), userparam.getAddress()
                    );
                    writer.write(userData);
                }
                System.out.println("User data saved to 'user_data.csv'.");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
 }

