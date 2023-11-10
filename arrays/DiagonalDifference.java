package arrays;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiagonalDifference {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifferenceBetter(arr);
        System.out.println(result);

        bufferedReader.close();
    }

        public static int diagonalDifference(List<List<Integer>> arr) {

            //Fix to 3
            int number1;
            int number2 = 0;
            int number3 = 0;

            int number4 = 0;
            int number5 = 0;
            int number6 = 0;

            int totalA = 0;
            int totalB = 0;
            
            for (int i = 0; i < 1; i++) {

                number1 = arr.get(i).get(i);
                number2 = arr.get(i + 1).get(i + 1);
                number3 = arr.get(i + 2).get(i + 2);

                number4 = arr.get(i).get(i + 2);
                number5 = arr.get(i + 1).get(i + 1);
                number6 = arr.get(i + 2).get(i);

                totalA = number1 + number2 + number3;
                totalB = number4 + number5 + number6;

            }

            return Math.abs(totalA - totalB);

        }

        public static int diagonalDifferenceBetter(List<List<Integer>> arr) {

            int diagonal1 = 0;
            int diagonal2 = 0;

            for (int i =0; i< arr.size(); i++) {
                diagonal1 += arr.get(i).get(i);
                diagonal2 += arr.get(i).get(arr.size() -1 -i);
            }

            return Math.abs(diagonal1-diagonal2);
        }



}
