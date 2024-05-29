package com.DAY_16;
public class NaivePatternSearch {

    public static void searchPattern(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int comparisonCount = 0;

        // Loop through the text to check for the pattern at each position
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            // Check for pattern match at the current position
            for (j = 0; j < patternLength; j++) {
                comparisonCount++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            // If the pattern is found
            if (j == patternLength) {
                System.out.println("Pattern found at index " + i);
            }
        }

        // Print the total number of comparisons made
        System.out.println("Total number of comparisons: " + comparisonCount);
    }

    public static void main(String[] args) {
        // Test case
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        searchPattern(text, pattern);
    }
}
