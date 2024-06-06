package com.DAY_26;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ModifiedUserAuthentication {
	private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "rps@2345";

    public static void main(String[] args) {
        createTable();
        insertUser("user1", "password123");
        authenticateUser();
    }

    private static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                + "UserID VARCHAR(255) PRIMARY KEY, "
                + "Password VARCHAR(255) NOT NULL"
                + ");";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {

            preparedStatement.executeUpdate();
            System.out.println("Table created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertUser(String userID, String password) {
        String checkUserSQL = "SELECT COUNT(*) FROM User WHERE UserID = ?";
        String insertSQL = "INSERT INTO User (UserID, Password) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
            // Check if the user already exists
            try (PreparedStatement checkUserStmt = connection.prepareStatement(checkUserSQL)) {
                checkUserStmt.setString(1, userID);
                ResultSet resultSet = checkUserStmt.executeQuery();
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    System.out.println("User already exists!");
                    return;
                }
            }
            
            // Insert the user if they don't exist
            try (PreparedStatement insertStmt = connection.prepareStatement(insertSQL)) {
                insertStmt.setString(1, userID);
                insertStmt.setString(2, hashPassword(password));
                insertStmt.executeUpdate();
                System.out.println("User inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static void authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        String selectSQL = "SELECT Password FROM User WHERE UserID = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            preparedStatement.setString(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String storedHashedPassword = resultSet.getString("Password");
                String inputHashedPassword = hashPassword(password);

                if (storedHashedPassword.equals(inputHashedPassword)) {
                    System.out.println("User authenticated successfully!");
                } else {
                    System.out.println("Invalid credentials.");
                }
            } else {
                System.out.println("User not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}