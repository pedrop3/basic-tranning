package arrays;

import java.util.ArrayList;
import java.util.List;

public class BreackeingBestAndWorst {
    public static void main(String[] args) {

        List<Integer> scores = List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);
        breakingRecords(scores);

    }

    public static List<Integer> breakingRecords(List<Integer> scores) {

        List<Integer> result = new ArrayList<>();

        int frist = scores.stream().findFirst().orElseThrow();

        int hishestScore = frist;
        int lowestScore = frist;
        int countBest = 0;
        int countWorst = 0;

        for (int score : scores) {

            if (hishestScore < score) {
                hishestScore = score;
                countBest++;
            } else if (lowestScore > score) {
                lowestScore = score;
                countWorst++;
            }

        }

        result.add(countBest);
        result.add(countWorst);

        return result;

    }
}
