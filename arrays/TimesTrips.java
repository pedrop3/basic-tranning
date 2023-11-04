package arrays;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

public class TimesTrips {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int weightCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Float> weight = IntStream.range(0, weightCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Float::parseFloat)
                .collect(toList());

        int result = efficientJanitor(weight);
        int result2 = efficent(weight);
        System.out.println(result);
        System.out.println(result2);



        bufferedReader.close();
    }

    public static int efficientJanitor(List<Float> weight) {

        // passar por todos itens
        // salvar o valor atual com o proximo
        // fazer somar se for maior que 3 - add uma viagem e nex e net até fina

        int trip = 0;
        float total = 0.0F;

        for (int i = 0; i < weight.size(); i++) {
            total += weight.get(i);

            if (total >= 3.0F) {
                trip++;
                total = weight.get(i);
            }
        }

        if (total > 0.0F) {
            trip++;
        }

        return trip;
    }

    public static int efficent(List<Float> weight) {

        // Collections.sort(weight); // Sort the bags by weight in ascending order.
        int trips = 0; // Initialize the number of trips to 0.
        int left = 0; // Initialize the left pointer to the lightest bag.
        int right = weight.size() - 1; // Initialize the right pointer to the heaviest bag.

        while (left <= right) {
            if (weight.get(left) + weight.get(right) <= 3.00) {
                // If the sum of the lightest and heaviest bags is at most 3.00 pounds,
                // the janitor can carry both of them in one trip.
                left++;
                right--;
            } else {
                // If not, the heaviest bag cannot be paired with any other bag,
                // so the janitor carries the heaviest bag in a separate trip.
                right--;
            }
            trips++; // Increment the number of trips.
        }

        return trips;
    }
}
