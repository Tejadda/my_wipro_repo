/*Circular Queue Binary Search
===========================
Consider a circular queue (implemented using a fixed-size array) where the elements are sorted but have been rotated at an unknown index. Describe an approach to perform a binary search for a given element within this circular queue.

1.)Identify the Rotated Index:

=>Use binary search to find the index at which the rotation occurred. This index will be the smallest element in the circular queue.
=>This step is crucial as it helps in determining the actual position of the elements and how to adjust the binary search accordingly.
Perform Binary Search:

2.)Adjust the binary search algorithm to handle the circular nature of the queue.
=>Calculate the mid index, and check if the element at the mid index is the target.
=>If the target is found, return the index.
=>If the target is greater than the mid element, check if it lies between the mid and high indexes. If it does, adjust the low index accordingly; =>otherwise, adjust the high index.
=>If the target is less than the mid element, check if it lies between the mid and low indexes. If it does, adjust the high index accordingly; otherwise, adjust the low index.
3.)Repeat Until Found:
=>Continue the binary search until the target element is found or the low index surpasses the high index.

Here's a Java implementation of the binary search on a rotated sorted circular queue:*/

public class CircularQueueBinarySearch {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if mid element is on the left side of the rotated index
            if (nums[mid] >= nums[low]) {
                // Check if target lies between low and mid indexes
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1; // Adjust high index
                } else {
                    low = mid + 1; // Adjust low index
                }
            } else { // Mid element is on the right side of the rotated index
                // Check if target lies between mid and high indexes
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1; // Adjust low index
                } else {
                    high = mid - 1; // Adjust high index
                }
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);
        if (result != -1) {
            System.out.println("Target " + target + " found at index " + result);
        } else {
            System.out.println("Target " + target + " not found");
        }
    }
}
/*In this implementation:

=>We initialize low and high indices to perform binary search.
=>Inside the while loop, we calculate the mid index and compare the mid element with the target.
=>Based on the comparison and the position of the mid element relative to the rotated index, we adjust the low and high indices accordingly.
=>We continue the binary search until the target is found or the low index surpasses the high index.
=>This approach efficiently handles the binary search on a rotated sorted circular queue without using any additional space.*/






