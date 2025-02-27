package utilities;

import appDomain.AppDriver;
import shapes.Shape3D;

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
     * Sorts an array using Insertion Sort in descending order.
     */
    public static void insertionSort(Comparable[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            Comparable key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1] that are smaller than key one position ahead
            while (j >= 0 && array[j].compareTo(key) < 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Sorts an array using Merge Sort in descending order.
     *
     * Merge Sort is a divide-and-conquer algorithm that recursively splits the array into two halves,
     * sorts each half, and then merges the sorted halves back together.
     * 
     * @param array The array of Comparable objects to be sorted in descending order.
     */
    public static void mergeSort(Comparable[] array) {
        if (array.length < 2) {
            return; // Base case: If the array has 0 or 1 element, it is already sorted.
        }
        int mid = array.length / 2; // Find the middle index.
        Comparable[] left = new Comparable[mid]; // Create left subarray.
        Comparable[] right = new Comparable[array.length - mid];  // Create right subarray.

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        // Recursively sort both halves.
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halved together in des order
        merge(array, left, right);
    }

    /**
     * Merges two sorted subarrays into one in descending order.
     * 
     * This method takes two already sorted arrays (left and right) and combines them 
     * into a single sorted array, ensuring that the merged array maintains descending order.
     * 
     * @param array The original array where the merged values will be placed.
     * @param left The left subarray (sorted in des order).
     * @param right The right subarray (sorted in desc order).
     */
    private static void merge(Comparable[] array, Comparable[] left, Comparable[] right) {
        int i = 0, j = 0, k = 0;

        //compare elements from both subarrays and merge them in desc order.
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
}
