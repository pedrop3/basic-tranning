package FindValuesMaxMix;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        long minTotal = 0;
        long maxTotal = 0;
        

        long max = arr.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();

        long mix = arr.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow();
        
        if (max == mix) {
    
            long someValue = arr.stream()
                .skip(1)
                .mapToInt(Integer::intValue)
                .sum();

            System.out.println(someValue +" "+someValue);
            return;
        }

        long sumMin = arr.stream()
                .filter(x -> x != max)
                .map(x -> x + minTotal)
                .reduce(Long::sum)
                .orElseThrow();

        long sumMax = arr.stream()
                .filter(x -> x != mix)
                .map(x -> x + maxTotal)
                .reduce(Long::sum)
                .orElseThrow();

        System.out.println(sumMin + " " + sumMax);

    }
}