package arrays;

import java.util.Scanner;

public class ConstructTheArray {

    /*
     * Complete the 'countArray' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n = tamanho do do array
     * 2. INTEGER k = até quando numero vai o array
     * 3. INTEGER x = ultimo elemento
     */
    public static long countArray1(int n, int k, int x) {
        int[] ways = new int[n + 1];

        // Base cases:
        // One element: There is only one way to construct an array with one element.
        ways[1] = 1;

        // Two elements: There are two ways to construct an array with two elements:
        // 1, 1 or 1, 2.
        ways[2] = 2;

        // Fill the rest of the array using the recursive formula:
        for (int i = 3; i <= n; i++) {
            // The number of ways to construct an array of size `i` is the sum of:
            // - The number of ways to construct an array of size `i - 1` by filling the last element with `x`.
            // - The number of ways to construct an array of size `i - 1` by filling the last element with `1`.
            ways[i] = ways[i - 1] + ways[i - 1];
        }

        // Return the number of ways to construct an array of size `n`.
        return ways[x];

    }   

    static int countArray(int n, int k, int x) {
        if (n == 0) {
          return 1;
        }
      
        int count = 0;
        for (int i = x; i < k; i++) {
          count += countArray(n - 1, k, i);
        }
      
        return count;
      }
    public static void main(String[] args) {
        int n, k, x;

        // Read the input
        Scanner scanner = new Scanner(System.in);
        n = 4;
        k = 3;
        x = 2;

        // Find the number of ways to construct the array
        long ways = countArray(n, k, x);

        // Print the output
        System.out.println(ways);

    }
}
