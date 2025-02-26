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
     * Quick sort implementation
     * it chooses a pivot and splits the array into two sub-lists. 
     * it compares the elements with that pivot and keeps doing that until they are in the right place. 
     * when there is only one element left in the sub-array, as a single element is already sorted.
     */
    
    public static void quickSort(Comparable[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }
    
    /**
     * Helper method that applies the quicksort algorithm recursively.
     * 
     * @param array The array to be sorted.
     * @param low   The starting index of the portion to be sorted.
     * @param high  The ending index of the portion to be sorted.
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
     * Slices the array around a pivot such that elements smaller than
     * the pivot are on the left, and elements greater than the pivot are on the right.
     * 
     * @param array The array to partition.
     * @param low   The starting index.
     * @param high  The ending index (pivot position).
     * @return The partition index where the pivot is placed correctly.
     */

    private static int slice(Comparable[] array, int low, int high) {
        Comparable pivot = array[high]; // Choose the last element as the pivot
        int i = low - 1; // Index of the smaller element

        // Iterate through the array and rearrange elements
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
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
     * @param i     The index of the first element.
     * @param j     The index of the second element.
     */

    private static void swap(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
