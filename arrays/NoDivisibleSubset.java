package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoDivisibleSubset {

    public static void main(String[] args) {
        ArrayList s = new ArrayList<>(Arrays.asList(1, 7, 2, 4));
        ArrayList s1 = new ArrayList<>(
                Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436));
        int k = 3;
        int result = name(k, s);
        System.out.println(result);

    }

    public static int name(int k, List<Integer> s) {
        Map<Integer, Integer> remainderCounts = new HashMap<>();

        for (Integer number : s) {
            int remainder = number % k;
            remainderCounts.put(remainder, remainderCounts.getOrDefault(remainder, 0) + 1);
        }

        System.out.println(remainderCounts);

        int result = Math.min(remainderCounts.getOrDefault(0, 0), 1);

        for (int i = 1; i <= k / 2; i++) {
            result += Math.max(remainderCounts.getOrDefault(i, 0), remainderCounts.getOrDefault(k - i, 0));
        }

        if (k % 2 == 0) {
            result -= remainderCounts.getOrDefault(k / 2, 0);
        }

        return result;
    }

    public static int execute(int k, List<Integer> s) {
        int[] remainderCounts = new int[k];

        for (int num : s) {
            int remainder = num % k;
            remainderCounts[remainder]++;
        }

        int result = (remainderCounts[0] > 0) ? 1 : 0;

        for (int i = 1; i <= k / 2; i++) {
            result += (remainderCounts[i] > remainderCounts[k - i]) ? remainderCounts[i] : remainderCounts[k - i];
        }

        if (k % 2 == 0) {
            result -= remainderCounts[k / 2];
        }

        return result;
    }
}
