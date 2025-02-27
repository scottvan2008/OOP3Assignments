# Sorting Application - ReadMe

## Introduction
This application is designed to sort three-dimensional geometric shapes based on specified properties such as height, volume, or base area. It implements six different sorting algorithms, including Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort, and an Heap Sort. The application also provides benchmarking to compare sorting performance.

## Requirements
- Java 8
- Eclipse IDE (Recommended)
- Command-line interface (CLI) for execution

## Installation
1. Download and unzip the provided project folder.
2. Open Eclipse and import the project:
   - Go to `File` > `Import` > `Existing Projects into Workspace`.
   - Select `Browse` and navigate to the unzipped project folder.
   - Click `Finish`.
3. Ensure Java 8 is installed and configured in Eclipse.
4. Compile the project to generate `Sort.jar`.

## Running the Program
The program is executed via the command line using a Java Archive (JAR) file. Below is the command format:

```sh
java -jar Sort.jar -f<file_name> -t<sorting_criteria> -s<sorting_algorithm>
```

### Command-line Arguments:
- `-f` or `-F` (File Path): Specifies the input file containing shape data.
- `-t` or `-T` (Sorting Criteria): Determines how the shapes are sorted.
  - `h` for height
  - `v` for volume
  - `a` for base area
- `-s` or `-S` (Sorting Algorithm): Specifies the sorting algorithm to use.
  - `b` for Bubble Sort
  - `i` for Insertion Sort
  - `s` for Selection Sort
  - `m` for Merge Sort
  - `q` for Quick Sort
  - `z` for the custom sorting algorithm

### Example Commands:
```sh
java -jar Sort.jar -fshapes1.txt -Tv -Sb
java -jar Sort.jar -ta -sQ -f"res\shapes1.txt"
java -jar Sort.jar -tH -F"C:\temp\shapes1.txt" -sB
```

## Input File Format
The input file contains shape data in the following format:
- The first line specifies the number of shapes.
- Each subsequent line represents a shape with its type and dimensions.

### Shape Types and Format:
- `Cylinder <height> <radius>`
- `Cone <height> <radius>`
- `Pyramid <height> <edge_length>`
- `SquarePrism <height> <edge_length>`
- `TriangularPrism <height> <edge_length>`
- `PentagonalPrism <height> <edge_length>`
- `OctagonalPrism <height> <edge_length>`

### Example Input:
```
4
Cylinder 9431.453 4450.123
Cone 674.2435 652.1534
Pyramid 6247.53 2923.456
SquarePrism 8945.234 3745.334
```

## Output
The program outputs:
1. The time taken to sort the shapes for each sorting algorithm (in milliseconds).
2. The first sorted shape, last sorted shape, and every thousandth value in between.
3. Error messages if invalid command-line arguments are provided.

## Notes
- Sorting is done in descending order.
- Invalid command-line arguments result in meaningful error messages.


## Troubleshooting
- Ensure Java 8 is installed and added to system PATH.
- If the program does not run, verify the file path and formatting of the input file.
- If performance issues arise, test with smaller datasets first.

## Authors
Developed by Team Rauru.

