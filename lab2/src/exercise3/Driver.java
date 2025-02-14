package exercise3;

import java.util.Random;
import java.util.Arrays;

public class Driver {
    // Constant variables defining the size of the array and the upper bound for random numbers
    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 1000;

    public static void main(String[] args) {
        // Ensure exactly one argument is provided to specify the sorting method
        if (args.length != 1) {
            System.out.println("Please provide one sorting method: b (Bubble Sort), i (Insertion Sort), s (Selection Sort), or q (QuickSort)");
            return;
        }

        // Extract the first character of the input argument as the sorting choice
        char choice = args[0].charAt(0);
        Integer[] nums = new Integer[SIZE];
        Random rand = new Random();

        // Populate the array with random integers within the specified upper bound
        for (int i = 0; i < SIZE; i++) {
            nums[i] = rand.nextInt(UPPER_BOUND);
        }

        // Display the original unsorted array
        System.out.println("Original array:");
        System.out.println(Arrays.toString(nums));

        // Determine the sorting method based on user input
        switch (choice) {
            case 'b':
                bubbleSort(nums);
                System.out.println("Sorted using Bubble Sort:");
                System.out.println(Arrays.toString(nums));
                break;
            case 'i': case 's': case 'q':  
                System.out.println("Sorry, this function is under development. Please try again later. Only bubble sort is available for now.");
                break;
            default:
                System.out.println("Invalid choice. Use b, i, s, or q.");
                return;
        }
        
    }

    // Bubble Sort implementation (Descending Order)
    public static void bubbleSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) { // Swap if the current element is smaller than the next one
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
