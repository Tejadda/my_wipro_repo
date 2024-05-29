package com.DAY_18;
public class UniqueElements {
    public static int[] findUniqueElements(int[] nums) {
        // Step 1: XOR all elements to get the XOR of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find a set bit (rightmost set bit) in the XOR result
        int setBit = xor & -xor; // This isolates the rightmost set bit

        // Step 3: Divide elements into two groups and XOR each group
        int unique1 = 0, unique2 = 0;
        for (int num : nums) {
            if ((num & setBit) != 0) {
                unique1 ^= num; // XOR of first group
            } else {
                unique2 ^= num; // XOR of second group
            }
        }

        return new int[]{unique1, unique2};
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2, 5};
        int[] result = findUniqueElements(nums);
        System.out.println("The two unique elements are: " + result[0] + " and " + result[1]);
    }
}

