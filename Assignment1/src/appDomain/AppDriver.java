/**
 * @author Sijerina Nepal
 * @author Maria Xavier
 * @author Wenhan Liu
 * @author Scott Yinan Fan
 */


package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Cone;
import shapes.Shape3D;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import utilities.Result;
import utilities.Sort;

public class AppDriver {

    // Static variables to store sorting type, algorithm, file name, and shape index
    public static char sortType = 'v'; // Default sort type (e.g., by volume)
    public static char sortAlgorithm = 'b'; // Default sort algorithm (e.g., bubble sort)
    public static String fileName = ""; // File name to read shapes from
    public static int shapeIndex = 0; // Index to track the number of shapes added to the array
    public static Shape3D[] shapesArray; // Array to store 3D shapes

    public static void main(String[] args) {
        // Step 1: Parse command-line arguments to get file path and sorting directions
        getFilePathAndSortDirections(args);

        // Step 2: Read the file, create shapes, and populate the shapes array
        int numberOfShapes = createAndPopulateArray();

        // Step 3: Sort the shapes array and measure the time taken
        Result r = sortTheArrayAndCountTime();

        // Step 4: Display the results, including sorted shapes and sorting time
        finalScreenDisplay(numberOfShapes, r);
    }

    /**
     * Displays the results of the sorting process.
     * 
     * @param numberOfShapes Total number of shapes in the array.
     * @param r Result object containing sorting algorithm name and time taken.
     */
    public static void finalScreenDisplay(int numberOfShapes, Result r) {
        // Print the first element in the sorted array
        System.out.println("First element is: " + shapesArray[0].print());

        // Print every 1000th element in the sorted array
        for (int i = 999; i < shapesArray.length; i += 1000) {
            System.out.println((i + 1) + "th element is: " + shapesArray[i].print());
        }

        // Print the second last and last elements in the sorted array
        System.out.println("Second last element is: " + shapesArray[numberOfShapes - 2].print());
        System.out.println("Last element is: " + shapesArray[numberOfShapes - 1].print());

        // Print the sorting algorithm name and the time taken in milliseconds
        System.out.println(r.sortAlgorithmName + " run time was " + r.time / 1000000 + " milliseconds");
    }

    /**
     * Sorts the shapes array using the specified sorting algorithm and measures the time taken.
     * 
     * @return Result object containing the sorting algorithm name and time taken.
     */
    public static Result sortTheArrayAndCountTime() {
        long start = System.nanoTime(); // Start time measurement
        String sortAlgorithmName = "";

        // Perform sorting based on the selected algorithm
        switch (sortAlgorithm) {
            case 'b':
                Sort.bubbleSort(shapesArray); // Bubble sort
                sortAlgorithmName = "BubbleSort";
                break;
            // Add cases for other sorting algorithms (e.g., selection, insertion, merge, quick)
            default:
                System.out.println("Invalid sort: -s or -S followed by b (bubble), s (selection), i (insertion), m (merge), q (quick) or z\r\n"
                        + "(your choice of sorting algorithm) with no spaces\r\n"
                        + "");
                break;
        }

        long stop = System.nanoTime(); // Stop time measurement
        // Create a Result object with the sorting algorithm name and time taken
        Result r1 = new Result(sortAlgorithmName, stop - start);
        return r1;
    }

    /**
     * Reads the input file, creates shapes, and populates the shapes array.
     * 
     * @return Total number of shapes read from the file.
     */
    public static int createAndPopulateArray() {
        File inputFile = new File(fileName);
        try (Scanner input = new Scanner(inputFile)) {
            // Read the total number of shapes from the file
            int numberOfShapes = input.nextInt();
            shapesArray = new Shape3D[numberOfShapes];

            // Read each shape's type, height, and base length, then create and store the shape
            while (input.hasNext()) {
                String shapeType = input.next();
                double height = input.nextDouble();
                double base_length = input.nextDouble();

                Shape3D shape = createShape(shapeType, height, base_length);
                if (shape != null) {
                    shapesArray[shapeIndex] = shape;
                    shapeIndex++;
                }
            }
            return numberOfShapes;
        } catch (FileNotFoundException e) {
            // Handle file not found exception
            System.out.println("File not found!");
            System.out.println("-f or -F followed by file_name (the file name and path) with no spaces");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Creates a 3D shape object based on the given type, height, and base length.
     * 
     * @param shapeType Type of the shape (e.g., Cone, Cylinder).
     * @param height Height of the shape.
     * @param base_length Base length of the shape.
     * @return A Shape3D object or null if the shape type is invalid.
     */
    private static Shape3D createShape(String shapeType, double height, double base_length) {
        switch (shapeType) {
            case "Cone":
                return new Cone(height, base_length);
            case "Cylinder":
                return new Cylinder(height, base_length);
            case "OctagonalPrism":
                return new OctagonalPrism(height, base_length);
            case "PentagonalPrism":
                return new PentagonalPrism(height, base_length);
            case "Pyramid":
                return new Pyramid(height, base_length);
            case "SquarePrism":
                return new SquarePrism(height, base_length);
            case "TriangularPrism":
                return new TriangularPrism(height, base_length);
            default:
                return null; // Return null for invalid shape types
        }
    }

    /**
     * Parses command-line arguments to get the file path and sorting directions.
     * 
     * @param args Command-line arguments passed to the program.
     */
    public static void getFilePathAndSortDirections(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

            // Check for file path argument
            if (arg.startsWith("-f") || arg.startsWith("-F")) {
                if (arg.contains("\\")) {
                    fileName = arg.substring(2); // Use the provided file path
                } else {
                    fileName = "res/" + arg.substring(2); // Default to the "res" folder
                    System.out.println(arg);
                }
            }
            // Check for sorting type argument (e.g., by volume or base area)
            else if (arg.startsWith("-t") || arg.startsWith("-T")) {
                sortType = Character.toLowerCase(arg.charAt(2));
            }
            // Check for sorting algorithm argument (e.g., bubble sort, selection sort)
            else if (arg.startsWith("-s") || arg.startsWith("-S")) {
                sortAlgorithm = Character.toLowerCase(arg.charAt(2));
            }
        }
    }
}