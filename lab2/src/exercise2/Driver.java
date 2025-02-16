package exercise2;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 10;

    public static void main(String[] args) {
        Integer[] nums = new Integer[SIZE];
        
        Random rand = new Random();
        
        nums[0] = rand.nextInt(UPPER_BOUND);

        for (int i = 1; i < SIZE; i++) {
            nums[i] = nums[i - 1] + rand.nextInt(UPPER_BOUND);
            System.out.println(nums[i]); // Print each element to the console
        }

        // Initialize a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target number to search: ");
        int target = scanner.nextInt(); // Read the target number from the user
        scanner.close(); // Close the scanner to free resources

        // Perform a binary search on the array to find the target number
        int result = binarySearch(nums, target);
        
        // Check if the target was found and print the appropriate message
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the list.");
        }
    }

    // Binary search method to find the target in a sorted array
    public static int binarySearch(Integer[] nums, int target) {
        int left = 0, right = nums.length - 1; // Initialize the search boundaries

        // Continue searching while the left boundary is less than or equal to the right boundary
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // Check if the middle element is the target
            if (nums[mid] == target) {
                return mid; // Return the index of the target
            } else if (nums[mid] < target) {
                left = mid + 1; // Adjust the left boundary if the target is in the right half
            } else {
                right = mid - 1; // Adjust the right boundary if the target is in the left half
            }
        }

        return -1; // Return -1 if the target is not found in the array
    }
}