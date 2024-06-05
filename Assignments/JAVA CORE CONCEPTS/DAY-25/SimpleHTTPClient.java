package com.DAY_25;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHTTPClient {
    public static void main(String[] args) {
        String urlString = "http://example.com";

        try {
            // Create a URL object with the specified URL string
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read and print response headers
            System.out.println("Response Headers:");
            connection.getHeaderFields().forEach((key, value) -> {
                System.out.println(key + ": " + value);
            });

            // Read and print response body
            System.out.println("\nResponse Body:");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}