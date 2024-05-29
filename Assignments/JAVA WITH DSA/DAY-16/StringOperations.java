package com.DAY_16;

public class StringOperations {
	 public static String processStrings(String str1, String str2, int length) {
	        if (str1 == null) str1 = "";
	        if (str2 == null) str2 = "";

	        // Concatenate the strings
	        String concatenated = str1 + str2;

	        // Reverse the concatenated string
	        String reversed = new StringBuilder(concatenated).reverse().toString();

	        // If length is non-positive, return an empty string
	        if (length <= 0) {
	            return "";
	        }

	        // If the requested substring length is greater than the reversed string length, return the whole reversed string
	        if (length >= reversed.length()) {
	            return reversed;
	        }

	        // Calculate the starting index for the middle substring
	        int start = (reversed.length() - length) / 2;

	        // Extract and return the middle substring
	        return reversed.substring(start, start + length);
	    }

	    public static void main(String[] args) {
	        // Test cases
	        System.out.println(processStrings("hello", "world", 5)); // "dlrow"
	        System.out.println(processStrings("hello", "", 3));      // "lle"
	        System.out.println(processStrings("", "world", 4));      // "dlro"
	        System.out.println(processStrings("hello", "world", 15)); // "dlrowolleh"
	        System.out.println(processStrings("hello", "world", 0));  // ""
	        System.out.println(processStrings("hello", "world", -2)); // ""
	    }
}
