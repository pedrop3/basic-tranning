package Math;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

//You are in charge of the cake for a child's birthday. You have decided the cake will have one candle for each year of their total age. They will only be able to blow out the tallest of the candles. Count how many candles are tallest.

public class Birthday {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = birthdayCakeCandles(candlesCount, candles);

        System.out.println(result);

        bufferedReader.close();
    }

    /*
     * Complete the 'birthdayCakeCList<Integer>andles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(int candlesCount, List<Integer> candles) {

        int tallestCandleHeight = candles
                .stream()
                .max(Integer::compareTo)
                .orElseThrow();

        long candleHeightTotal = candles
                .stream()
                .filter(candleHeight -> candleHeight == tallestCandleHeight)
                .count();

        return (int) candleHeightTotal;

    }
}
