package com.DAY_25;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java WordFrequencyCounter <inputFilePath> <outputFilePath>");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            // Read input file and count word frequencies
            Map<String, Integer> wordFrequencyMap = countWordFrequencies(inputFilePath);

            // Write word-frequency pairs to output file
            writeWordFrequencies(wordFrequencyMap, outputFilePath);

            System.out.println("Word frequencies written to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Method to read input file and count word frequencies
    private static Map<String, Integer> countWordFrequencies(String inputFilePath) throws IOException {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split line into words by whitespace
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }

        return wordFrequencyMap;
    }

    // Method to write word-frequency pairs to output file
    private static void writeWordFrequencies(Map<String, Integer> wordFrequencyMap, String outputFilePath) throws IOException {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
        }
    }
}