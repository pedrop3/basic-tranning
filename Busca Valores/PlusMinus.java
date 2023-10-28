import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr, int n) {

        DecimalFormat df = new DecimalFormat("0.000000");

        long possitiveNumber = arr.stream()
                .filter(x -> x > 0)
                .count();

        long negativeNumber = arr.stream()
                .filter(x -> x < 0)
                .count();

        long zeroList = arr.stream()
                .filter(x -> x == 0)
                .count();

        String positiveRatio = df.format((double) possitiveNumber / n);
        String netativeRatio = df.format((double) negativeNumber / n);
        String zeroRatio = df.format((double) zeroList / n);

        System.out.println(positiveRatio);
        System.out.println(netativeRatio);
        System.out.println(zeroRatio);

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr, n);

        bufferedReader.close();
    }
}
