package arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSwaps {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        scanner.close();
    }

    static int minimumSwaps(int[] arr) {

        int n = arr.length;
        int swaps = 0;
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < n; i++) {
            while (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                swaps++;
                System.out.println(Arrays.toString(arr));
            }
        }

        return swaps;

    }
}
