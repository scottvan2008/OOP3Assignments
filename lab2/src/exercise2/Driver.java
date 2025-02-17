// Static method BinarySearch with sorted list and target number as it's parameter
// and it's implementation

package exercise2;

import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static final int SIZE = 100;
	public static final int UPPER_BOUND = 10;

	public static void main(String[] args) {

		Integer[] nums = new Integer[SIZE]; // List to search the target in
		Random rand = new Random(); // Object of Random class
		int randnum = rand.nextInt(UPPER_BOUND); // First random number
		nums[0] = randnum;
		Scanner scan = new Scanner(System.in); // Object of Scanner class
		int target, targetIndex;

		// Populate the array
		for (int i = 1; i < SIZE; i++) {
			randnum = rand.nextInt(UPPER_BOUND);
			nums[i] = nums[i - 1] + randnum;
		}

		// Print the array
		System.out.println("The sorted list is: ");
		for (int i = 0; i < nums.length; i++) {
			System.out.println(i + ". " + nums[i]);
		}

		System.out.println("Enter the target number to find in the list");
		target = scan.nextInt(); // Taking the user input for target

		// Binary search to see if the method is in the list
		targetIndex = BinarySearch(nums, target);
		if (targetIndex == -1) {
			System.out.println("\nThe target number " + target + " is not on the list");
		} else {
			System.out.println("\nThe target number " + target + " is on the index " + targetIndex);
		}
		scan.close();
	}

	public static int BinarySearch(Integer[] list, Integer target) {
		int min = 0;
		int max = list.length - 1;
		int midpoint = (min + max) / 2;

		while (min <= max) {
			midpoint = (min + max) / 2;
			if (list[midpoint].compareTo(target) == 0) // The target is equal to the current mid inde
				return midpoint;
			else if (list[midpoint].compareTo(target) > 0) { // The target is in left half
				max = midpoint - 1;
			} else if (list[midpoint].compareTo(target) < 0) { // The target in in right half
				min = midpoint + 1;
			}
		}
		return -1; // The target could not be found
	}

}
