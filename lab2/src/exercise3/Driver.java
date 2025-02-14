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
                break;
            case 'i':
                insertionSort(nums);
                System.out.println("Sorted using Insertion Sort:");
                break;
            case 's':
                selectionSort(nums);
                System.out.println("Sorted using Selection Sort:");
                break;
            case 'q':
                quickSort(nums, 0, nums.length - 1);
                System.out.println("Sorted using QuickSort:");
                break;
            default:
                System.out.println("Invalid choice. Use b, i, s, or q.");
                return;
        }
        
        // Display the sorted array
        System.out.println(Arrays.toString(nums));
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

    // Insertion Sort implementation (Descending Order)
    public static void insertionSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Shift elements to the right to find the correct position for key
            while (j >= 0 && arr[j] < key) { 
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort implementation (Descending Order)
    public static void selectionSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i; // Assume the maximum is at index i
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) { // Find the maximum value in the remaining array
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, i); // Swap the found maximum with the first element of the unsorted portion
        }
    }

    // QuickSort implementation (Descending Order)
    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Get the partition index
            quickSort(arr, low, pi - 1); // Recursively sort elements before partition
            quickSort(arr, pi + 1, high); // Recursively sort elements after partition
        }
    }

    // Partition function for QuickSort (Descending Order)
    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element (choosing the last element as pivot)
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) { // Move elements greater than pivot to the left
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high); // Place pivot in its correct position
        return i + 1;
    }

    // Swap function to exchange two elements in the array
    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
