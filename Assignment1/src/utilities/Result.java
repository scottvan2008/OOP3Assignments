package utilities;

// This class represents the result of a sorting operation, storing the name of the sorting algorithm
// and the time it took to complete the sorting process.
public class Result {
    
    // The name of the sorting algorithm used (e.g., "Bubble Sort", "Merge Sort").
    public String sortAlgorithmName;
    
    // The time taken by the sorting algorithm to complete the operation, measured in milliseconds or nanoseconds.
    public long time;

    /**
     * Default constructor for the Result class.
     * Initializes the object with default values for sortAlgorithmName and time.
     */
    public Result() {
        // Default constructor does not initialize fields explicitly.
    }

    /**
     * Parameterized constructor for the Result class.
     * 
     * @param sortAlgorithmName The name of the sorting algorithm used.
     * @param time The time taken by the sorting algorithm to complete the operation.
     */
    public Result(String sortAlgorithmName, long time) {
        this.sortAlgorithmName = sortAlgorithmName;  // Sets the name of the sorting algorithm.
        this.time = time;  // Sets the time taken for sorting.
    }
}