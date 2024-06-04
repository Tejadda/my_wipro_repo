package com.DAY_24;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;
    private int age;

    // Private constructor
    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Public method
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    // Private method
    private void secretMethod() {
        System.out.println("This is a secret method.");
    }
}

public class ReflectionExample {

    public static void main(String[] args) {
        try {
            // Obtain the Class object for the Person class
            Class<Person> personClass = Person.class;

            // Inspect constructors
            System.out.println("Constructors:");
            for (Constructor<?> constructor : personClass.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

            // Inspect methods
            System.out.println("\nMethods:");
            for (Method method : personClass.getDeclaredMethods()) {
                System.out.println(method);
            }

            // Inspect fields
            System.out.println("\nFields:");
            for (Field field : personClass.getDeclaredFields()) {
                System.out.println(field);
            }

            // Create an instance of the Person class using reflection
            Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true); // Make the private constructor accessible
            Person person = constructor.newInstance("TejaswiDda", 21);

            // Modify the access level of the private field 'name' and set its value
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true); // Make the private field accessible
            nameField.set(person, "TejaswiDda");

            // Invoke the public method to see the changes
            Method displayInfoMethod = personClass.getMethod("displayInfo");
            displayInfoMethod.invoke(person);

            // Invoke the private method
            Method secretMethod = personClass.getDeclaredMethod("secretMethod");
            secretMethod.setAccessible(true); // Make the private method accessible
            secretMethod.invoke(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

