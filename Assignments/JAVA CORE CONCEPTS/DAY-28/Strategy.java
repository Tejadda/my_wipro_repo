package com.DAY_28;
import java.util.Arrays;
//Strategy interface
interface SortingStrategy {
 void sort(int[] array);
}

//Concrete strategy classes
class BubbleSortStrategy implements SortingStrategy {
 @Override
 public void sort(int[] array) {
     System.out.println("Sorting using Bubble Sort");
     // Bubble sort algorithm implementation
     for (int i = 0; i < array.length - 1; i++) {
         for (int j = 0; j < array.length - i - 1; j++) {
             if (array[j] > array[j + 1]) {
                 int temp = array[j];
                 array[j] = array[j + 1];
                 array[j + 1] = temp;
             }
         }
     }
 }
}

class QuickSortStrategy implements SortingStrategy {
 @Override
 public void sort(int[] array) {
     System.out.println("Sorting using Quick Sort");
     // Quick sort algorithm implementation
     quickSort(array, 0, array.length - 1);
 }

 private void quickSort(int[] array, int low, int high) {
     if (low < high) {
         int pivot = partition(array, low, high);
         quickSort(array, low, pivot - 1);
         quickSort(array, pivot + 1, high);
     }
 }

 private int partition(int[] array, int low, int high) {
     int pivot = array[high];
     int i = low - 1;
     for (int j = low; j < high; j++) {
         if (array[j] < pivot) {
             i++;
             int temp = array[i];
             array[i] = array[j];
             array[j] = temp;
         }
     }
     int temp = array[i + 1];
     array[i + 1] = array[high];
     array[high] = temp;
     return i + 1;
 }
}

class MergeSortStrategy implements SortingStrategy {
 @Override
 public void sort(int[] array) {
     System.out.println("Sorting using Merge Sort");
     // Merge sort algorithm implementation
     mergeSort(array, 0, array.length - 1);
 }

 private void mergeSort(int[] array, int low, int high) {
     if (low < high) {
         int mid = (low + high) / 2;
         mergeSort(array, low, mid);
         mergeSort(array, mid + 1, high);
         merge(array, low, mid, high);
     }
 }

 private void merge(int[] array, int low, int mid, int high) {
     int[] left = Arrays.copyOfRange(array, low, mid + 1);
     int[] right = Arrays.copyOfRange(array, mid + 1, high + 1);
     int i = 0, j = 0, k = low;
     while (i < left.length && j < right.length) {
         if (left[i] < right[j]) {
             array[k++] = left[i++];
         } else {
             array[k++] = right[j++];
         }
     }
     while (i < left.length) {
         array[k++] = left[i++];
     }
     while (j < right.length) {
         array[k++] = right[j++];
     }
 }
}

//Context class
class Sorter {
 private SortingStrategy strategy;

 public Sorter(SortingStrategy strategy) {
     this.strategy = strategy;
 }

 public void setStrategy(SortingStrategy strategy) {
     this.strategy = strategy;
 }

 public void sort(int[] array) {
     strategy.sort(array);
 }
}

//Client code
public class Strategy {
 public static void main(String[] args) {
     int[] array = {4, 2, 7, 1, 3};

     Sorter sorter = new Sorter(new BubbleSortStrategy());
     sorter.sort(array);
     System.out.println("Sorted array using Bubble Sort: " + Arrays.toString(array));

     sorter.setStrategy(new QuickSortStrategy());
     sorter.sort(array);
     System.out.println("Sorted array using Quick Sort: " + Arrays.toString(array));

     sorter.setStrategy(new MergeSortStrategy());
     sorter.sort(array);
     System.out.println("Sorted array using Merge Sort: " + Arrays.toString(array));
 }
}