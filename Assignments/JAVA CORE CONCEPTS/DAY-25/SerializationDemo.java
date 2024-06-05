package com.DAY_25;
import java.io.Serializable;
import java.io.*;
class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
public class SerializationDemo {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Alice", 30);

        // Serialize the Person object
        serializeObject(person, "person.ser");

        // Deserialize the Person object
        Person deserializedPerson = deserializeObject("person.ser");

        // Print the details of the deserialized Person object
        if (deserializedPerson != null) {
            System.out.println("Deserialized Person:");
            System.out.println("Name: " + deserializedPerson.getName());
            System.out.println("Age: " + deserializedPerson.getAge());
        }
    }

    // Method to serialize an object and write it to a file
    private static void serializeObject(Object obj, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
            System.out.println("Object serialized and written to " + fileName);
        } catch (IOException e) {
            System.err.println("Error occurred during serialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to deserialize an object from a file
    private static Person deserializeObject(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object obj = objectIn.readObject();
            if (obj instanceof Person) {
                return (Person) obj;
            } else {
                System.err.println("Error: The deserialized object is not of type Person");
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred during deserialization: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
