import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaxValue2 {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        Integer listSize = in.nextInt();

        for (int i = 0; i <= listSize; i++) {

            Integer value = in.nextInt();
            integerList.add(value);

        }

        int maxInteger = maxValuePerformace2(integerList);
        int minInteger = minValuePerformace2(integerList);

        System.out.println("Maior: " + maxInteger);

        System.out.println("Menor: " + minInteger);

    }

    // O(n log n)
    public static Integer maxValue(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    // O(n log n)
    public static Integer minValue(List<Integer> list) {
        Collections.sort(list);
        return list.get(0);
    }

    // O(n)
    public static Integer maxValuePerformace(List<Integer> list) {
        int max = list.get(0);

        for (Integer value : list) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    // O(n)
    public static Integer minValuePerformace(List<Integer> list) {
        int min = list.get(0);

        for (Integer value : list) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    // O(n)
    public static Integer maxValuePerformace2(List<Integer> list) {
        return Collections.max(list);
    }

    // O(n)
    public static Integer minValuePerformace2(List<Integer> list) {
        return Collections.min(list);
    }

    // O(n)
    public static Integer maxValuePerformace3(List<Integer> list) {
        return list.stream().max(Comparator.naturalOrder()).orElseThrow();
    }

    // O(n)
    public static Integer minValuePerformace3(List<Integer> list) {
        return list.stream().min(Comparator.naturalOrder()).orElseThrow();
    }
}
