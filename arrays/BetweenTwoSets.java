package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {
    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>(Arrays.asList(2, 4));
        List<Integer> b = new ArrayList<>(Arrays.asList(16, 32, 96));

        getTotalX(a, b);

    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        List<Integer> multiplesOfA = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            if (isMultpleOfA(i, a)) {
                multiplesOfA.add(i);
            }
        }

        // verifica
        int count = 0;
        for (int candidate : multiplesOfA) {
            if (isFactorOfB(candidate, b)) {
                count++;
            }
        }

        return count;
    }

    static boolean isMultpleOfA(int num, List<Integer> a) {
        for (int factor : a) {
            if (num % factor != 0) {
                return false;
            }
        }
        return true;

    }

    // Verifica se 'num' é fator de todos os elementos de 'b'
    static boolean isFactorOfB(int num, List<Integer> b) {
        for (int factor : b) {
            if (factor % num != 0) {
                return false;
            }
        }
        return true;
    }
}
