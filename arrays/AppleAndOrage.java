package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleAndOrage {

    public static void main(String[] args) {
        List<Integer> apples = new ArrayList<>(Arrays.asList(-2, 2, 1));
        List<Integer> oranges = new ArrayList<>(Arrays.asList(5, -6));

        int startSamHouse = 7;
        int endSamHouse = 11;

        int locationAppleTree = 5;
        int locationOragenTree = 15;

        countApplesAndOranges(startSamHouse, endSamHouse, locationAppleTree, locationOragenTree, apples, oranges);

    }

    public static void countApplesAndOranges(int startSamHouse, int endSamHouse, int locationAppleTree,
            int locationOragenTree, List<Integer> apples, List<Integer> oranges) {

        int countApple = countFruitsDistance(startSamHouse, endSamHouse, locationAppleTree, apples);
        int countOragen = countFruitsDistance(startSamHouse, endSamHouse, locationOragenTree, oranges);

        System.out.println(countApple);
        System.out.println(countOragen);

    }

    private static int countFruitsDistance(int startSamHouse, int endSamHouse, int locationOragenTree,
            List<Integer> distances) {
        int count = 0;

        for (int appleCurrentDistance : distances) {
            int possition = locationOragenTree + appleCurrentDistance;

            if (possition >= startSamHouse && possition <= endSamHouse) {
                count++;
            }
        }

        return count;
    }
}
