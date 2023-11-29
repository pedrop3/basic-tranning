package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MigratoryBirds {

    public static void main(String[] args) {

        List<Integer> arrs = new ArrayList<>(Arrays.asList(1, 4, 4, 4, 5, 3));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4));

        System.out.println(migratoryBirds(arrs));

    }

    public static int migratoryBirds(List<Integer> arr) {

        HashMap<Integer, Integer> birdCounts = new HashMap<>();

        for (int birdType : arr) {
            birdCounts.putIfAbsent(birdType, 0);
            birdCounts.put(birdType, birdCounts.get(birdType) + 1);
        }

        int maxCount = Integer.MIN_VALUE;
        int mostFrequentBirdType = -1;

        for (int birdType : birdCounts.keySet()) {
            int count = birdCounts.get(birdType);

            if (count > maxCount) {
                maxCount = count;
                mostFrequentBirdType = birdType;
            } else if (count == maxCount && birdType < mostFrequentBirdType) {
                mostFrequentBirdType = birdType;
            }
        }

        return mostFrequentBirdType;
    }

}
