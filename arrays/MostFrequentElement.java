package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MostFrequentElement {

    // Método O(n²) - Brute Force
    public static int mostFrequentBruteForce(int[] nums) {
        int maxCount = 0;
        int mostFrequent = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = nums[i];
            }
        }
        return mostFrequent;
    }

    // Método O(n) - HashMap
    public static int mostFrequentOptimized(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int mostFrequent = nums[0];
        int maxCount = 0;

        for (int num : nums) {
            int count = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, count);

            if (count > maxCount) {
                maxCount = count;
                mostFrequent = num;
            }
        }
        return mostFrequent;
    }

}
