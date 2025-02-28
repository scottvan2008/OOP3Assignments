package utilities;

import appDomain.AppDriver;
import shapes.Shape3D;

import java.util.Arrays;

// This class provides utility methods for sorting arrays of Comparable objects.
// Currently, it implements the Bubble Sort algorithm for sorting in descending order.
public class Sort {

    /**
     * Sorts an array of Comparable objects using the Bubble Sort algorithm in descending order.
     *
     * Bubble Sort repeatedly steps through the list, comparing adjacent elements,
     * and swapping them if they are in the wrong order. The largest elements "bubble" to the front,
     * ensuring the array is sorted in descending order.
     *
     * @param array The array of Comparable objects to be sorted in descending order.
     */
    public static void bubbleSort(Comparable[] array) {
        int n = array.length;  // Get the length of the array.

        // Outer loop: Iterate through the array (n-1) times.
        for (int i = 0; i < n - 1; i++) {

            // Inner loop: Compare adjacent elements and swap if necessary.
            // The range decreases with each pass as the smallest elements "sink" to the end.
            for (int j = 0; j < n - i - 1; j++) {

                // If the current element is smaller than the next element, swap them.
                if (array[j].compareTo(array[j + 1]) < 0) {
                    Comparable temp = array[j];  // Store the current element in a temporary variable.
                    array[j] = array[j + 1];     // Move the next element to the current position.
                    array[j + 1] = temp;         // Assign the temporary variable to the next position.
                }
            }
        }
    }


    /**
     * Sorts the array in descending order using the quicksort algorithm.
     *
     * @param array The array to be sorted.
     */
    public static void quickSort(Comparable[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    /**
     * Helper method that applies the quicksort algorithm recursively.
     *
     * @param array The array to be sorted.
     * @param low The starting index of the portion to be sorted.
     * @param high The ending index of the portion to be sorted.
     */
    private static void quickSortHelper(Comparable[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = slice(array, low, high);

            // Recursively sort elements before and after partition
            quickSortHelper(array, low, partitionIndex - 1);
            quickSortHelper(array, partitionIndex + 1, high);
        }
    }

    /**
     * Slices the array around a pivot such that elements larger than
     * the pivot are on the left, and elements smaller than the pivot are on the right.
     * This creates a descending order sort.
     *
     * @param array The array to partition.
     * @param low The starting index.
     * @param high The ending index (pivot position).
     * @return The partition index where the pivot is placed correctly.
     */
    private static int slice(Comparable[] array, int low, int high) {
        Comparable pivot = array[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the larger element

        // Iterate through the array and rearrange elements
        for (int j = low; j < high; j++) {
            // Changed comparison direction for descending order (>= instead of <=)
            if (array[j].compareTo(pivot) >= 0) {
                i++;
                swap(array, i, j);
            }
        }

        // Swap pivot into correct position
        swap(array, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
     *
     * @param array The array in which elements are swapped.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private static void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void insertionSort(Comparable[] array) {
        int n = array.length;

        // We start iterating from index 1 because we assume the first element is already sorted.
        for (int i = 1; i < n; i++) {
            //key is the element that needs to be inserted in the sorted part of the array.
            Comparable key = array[i];
            int j = i - 1;


            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && array[j].compareTo(key) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }

    }


    /**
     * Sorts the array in descending order using the selection sort algorithm.
     * 
     * @param array The array to be sorted.
     */
    public static void selectionSort(Comparable[] array) {
        int n = array.length;

        // Iterate through the array
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i; // Assume the current index holds the largest element

            // Find the index of the largest element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }

            // Swap the found maximum element with the first element of the unsorted part
            if (maxIndex != i) {
                Comparable temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    public static void mergeSort(Comparable[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        Comparable[] left = Arrays.copyOfRange(array, 0, mid);
        Comparable[] right = Arrays.copyOfRange(array, mid, array.length);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private static void merge(Comparable[] array, Comparable[] left, Comparable[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) >= 0) {
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

    /**
     * Sorts the array in descending order using the heap sort algorithm.
     * 
     * @param array The array to be sorted.
     */
    public static void heapSort(Comparable[] array) {
        int n = array.length;
        
        // Build a min heap instead of a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    /**
     * Heapify procedure modified to create a min heap instead of a max heap.
     * 
     * @param array The array to heapify.
     * @param n The size of the heap.
     * @param i The index of the root element of the subtree.
     */
    private static void heapify(Comparable[] array, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // Find the smallest element among root, left child and right child
        if (left < n && array[left].compareTo(array[smallest]) < 0) {
            smallest = left;
        }
        
        if (right < n && array[right].compareTo(array[smallest]) < 0) {
            smallest = right;
        }
        
        // If smallest is not root
        if (smallest != i) {
            swap(array, i, smallest);
            heapify(array, n, smallest);
        }
    }

    /**
     * Swaps two elements in the array.
     * 
     * @param array The array in which elements are swapped.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    private static void swap1(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    
    
    
}
