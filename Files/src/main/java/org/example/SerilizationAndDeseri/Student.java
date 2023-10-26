package org.example.SerilizationAndDeseri;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Student implements  Serializable {
    private final String name;
    private int age;

    private String address;

    private double gpa;

    private List<String> courses = new ArrayList<>();

    private List<String> hobbies = new ArrayList<>();

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gpa=" + gpa +
                ", courses=" + courses +
                ", hobbies=" + hobbies +
                '}';
    }

    public Student(String name, int age, String address, double gpa) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public static void main(String[] args) {
        Student abi = new Student(
                "Abi",
                20,
                "Seesener str 41, Berlin",
                8.9
        );

        abi.addCourse("Maths");
        abi.addCourse("Science");
        abi.addCourse("Physics");
        abi.addCourse("Social");
        abi.addCourse("German");

        abi.addHobbies("Painting");
        abi.addHobbies("Singing");
        abi.addHobbies("Reading Books");

        Student.serialize(abi);
        Student loadedStudent =  Student.deserialize("student.ser");
        System.out.println(loadedStudent);
    }

    private static Student deserialize(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Student deserializedStudent = (Student) objectInputStream.readObject();
            return deserializedStudent;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void serialize(Student student) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("student.ser");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Student object serialized and saved to student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addHobbies(String hobby) {
        this.hobbies.add(hobby);
    }

    private void addCourse(String subject) {
        this.courses.add(subject);
    }
}
