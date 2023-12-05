package arrays;

import java.util.Arrays;

public class PythagoreanTriplet {

    static boolean hasPythagoreanTriplet(int[] arr) {
        int n = arr.length;

        // Square all elements in the array
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        // Sort the squared array
        Arrays.sort(arr);

        // Check for a triplet (a, b, c) such that a^2 + b^2 = c^2
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                if (arr[left] + arr[right] == arr[i]) {
                    return true; // Triplet found
                }

                if (arr[left] + arr[right] < arr[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        // No triplet found
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 6, 5}; // Example array

        // Check for Pythagorean triplet
        if (hasPythagoreanTriplet(arr)) {
            System.out.println("The array contains a Pythagorean triplet.");
        } else {
            System.out.println("No Pythagorean triplet found in the array.");
        }
    }
}
