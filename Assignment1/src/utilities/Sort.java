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
}
