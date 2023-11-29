package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiliHomeworks {

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(Arrays.asList(3, 2, 1));
        System.out.println(lilysHomework(arr));

    }

    public static int lilysHomework(List<Integer> arr) {
        List<Integer> arrCopy = new ArrayList<>(arr);
        List<Integer> reverseArrCopy = new ArrayList<>(arrCopy);

        Collections.sort(arrCopy);
        Collections.reverse(reverseArrCopy);

        int swapsAsc = getSwaps(arr, arrCopy);
        int swapsDesc = getSwaps(arr, reverseArrCopy);

        return Math.min(swapsAsc, swapsDesc);

    }

    static int getSwaps(List<Integer> arr, List<Integer> sortedArr) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            indexMap.put(arr.get(i), i);
        }

        int swaps = 0;

        for (int i = 0; i< arr.size(); i++) {
            if (!arr.get(i).equals(sortedArr.get(i))) {
                int orginalIndex = indexMap.get(sortedArr.get(i));
                indexMap.put(arr.get(i), orginalIndex);
                indexMap.put(sortedArr.get(i), i);

                Collections.swap(arr, i, orginalIndex);

                swaps++;
            }
        }

        return swaps;
    }

}
