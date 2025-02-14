package exercise2;

import java.util.Random;
import java.util.Scanner;

public class Driver {

    public static final int SIZE = 100;
    public static final int UPPER_BOUND = 10;

    public static void main(String[] args) {
        Integer[] nums = new Integer[SIZE];
        Random rand = new Random();
        nums[0] = rand.nextInt(UPPER_BOUND);

        for (int i = 1; i < SIZE; i++) {
            nums[i] = nums[i - 1] + rand.nextInt(UPPER_BOUND);
            System.out.println(nums[i]);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target number to search: ");
        int target = scanner.nextInt();
        scanner.close();

        int result = binarySearch(nums, target);
        
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the list.");
        }
    }

    public static int binarySearch(Integer[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }
}
