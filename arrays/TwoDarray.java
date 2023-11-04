package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwoDarray {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        // IntStream.range(0, 7).forEach(i -> {
        //     try {
        //         arr.add(
        //                 Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        //                         .map(Integer::parseInt)
        //                         .collect(toList()));
        //     } catch (IOException ex) {
        //         throw new RuntimeException(ex);
        //     }
        // });

        List<List<Integer>> arr2 = List.of(
            List.of(1, 1, 1, 0, 0, 0),
            List.of(0, 1, 0, 0, 0, 0),
            List.of(1, 1, 1, 0, 0, 0),
            List.of(0, 0, 2, 4, 4, 0),
            List.of(0, 0, 0, 2, 0, 0),
            List.of(0, 0, 1, 2, 4, 0)
        );

        int result = hourglassSum(arr2);
        bufferedReader.close();

    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;  // Initialize maxSum to the smallest possible integer value.


        int row = arr.size();
        int cols = arr.get(0).size();
        for (int i = 0; i < row -2 ; i++) {
            for (int j = 0; j < cols -2; j++) {
                // Calculate the sum of the current hourglass.
                int currentSum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                               + arr.get(i + 1).get(j + 1)
                               + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                // Update maxSum if the currentSum is greater.
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;



    }
}
