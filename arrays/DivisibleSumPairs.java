package arrays;

import java.util.List;

public class DivisibleSumPairs {

    public static void main(String[] args) {

        List<Integer> ar = List.of(1, 3, 2, 6, 1, 2);
        int k = 3;
        System.out.println(divisibleSumPairs(0, k, ar));

    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

        int numberOfPairs = 0;
        for (int i = 0; i <= ar.size(); i++) {
            for (int j = i + 1; j < ar.size(); j++) {

                boolean isDivisibleByK = (ar.get(i) + ar.get(j)) % k == 0;

                if (isDivisibleByK) {
                    numberOfPairs++;
                }
            }
        }

        return numberOfPairs;
    }

}
