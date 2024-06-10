package com.DAY_28;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DatabaseManager1 {
    private static volatile DatabaseManager1 INSTANCE = null;
    private Connection connection;

    private DatabaseManager1() {
        // Initialize database connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "rps@2345";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public static DatabaseManager1 getInstance() {
        if (INSTANCE == null) {
            synchronized (DatabaseManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DatabaseManager1();
                }
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Disconnected from database!");
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
}

public class DatabaseManager {
    public static void main(String[] args) {
        DatabaseManager1 dbManager = DatabaseManager1.getInstance();
        Connection connection = dbManager.getConnection();

        // Use the connection
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            dbManager.closeConnection();
        }
    }
}