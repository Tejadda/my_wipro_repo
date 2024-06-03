package com.DAY_23;
public class ArraySwapDemo {

    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 < 0 || index1 >= array.length || index2 < 0 || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid indices");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swapping:");
        printArray(intArray);
        swap(intArray, 1, 3); // Swap elements at indices 1 and 3
        System.out.println("After swapping:");
        printArray(intArray);

        // String array
        String[] strArray = {"apple", "banana", "orange", "grape"};
        System.out.println("\nBefore swapping:");
        printArray(strArray);
        swap(strArray, 0, 3); // Swap elements at indices 0 and 3
        System.out.println("After swapping:");
        printArray(strArray);
    }

    private static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
