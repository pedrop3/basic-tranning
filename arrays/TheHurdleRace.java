package arrays;

import java.util.List;

/**
 * TheHurdleRace
 */
public class TheHurdleRace {

    public static int hurdleRace(int k, List<Integer> height) {

        int max = height.stream().reduce(Integer::max).orElseThrow();

        if (k > max) {
            return 0;
        } else {
            return k - max;
        }
    }

}