package arrays;

import java.util.List;

public class TheBirhdayBar {
    public static void main(String[] args) {

        List<Integer> s = List.of(2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1);
        int day = 18;
        int month = 7;

        System.out.println(birthday(s, day, month));
    }

    // d is a day
    // m
    public static int birthday(List<Integer> s, int day, int month) {

        int piaceOfChochole = 0;

        for (int i = 0; i <= s.size() - month; i++) {
            List<Integer> partOfList = s.subList(i, month + i);

            boolean isPartTotal = partOfList.stream()
                    .reduce(Integer::sum)
                    .filter(x -> x == day)
                    .isPresent();

            if (isPartTotal) {
                piaceOfChochole++;
            }
        }

        return piaceOfChochole;
    }
}
