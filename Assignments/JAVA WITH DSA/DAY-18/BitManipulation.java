package com.DAY_18;
public class BitManipulation {

    // Function to count the number of set bits in an integer
    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;  // Add the least significant bit
            num >>= 1;         // Right shift to process the next bit
        }
        return count;
    }
 // Function to count the total number of set bits in all integers from 1 to n
    public static int countTotalSetBits(int n) {
        int totalSetBits = 0;
        for (int i = 1; i <= n; i++) {
            totalSetBits += countSetBits(i);
        }
        return totalSetBits;
    }

    public static void main(String[] args) {
        int number = 29;  // Example number
        int n = 5;//Example value of n
        System.out.println("Number of set bits in " + number + " is: " + countSetBits(number));
        System.out.println("Total number of set bits from 1 to " + n + " is: " + countTotalSetBits(n));
    }
}
