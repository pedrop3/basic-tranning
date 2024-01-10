package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    return list.stream()
        .distinct()
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 2, 4, 5, 4, 6 };
    removeWithSet(arr);

    int[] arr2 = Arrays.stream(arr).distinct().toArray();

    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6));

    System.out.println("List: " + Arrays.toString(arr2));
    System.out.println("Old List: " + arrayList);
    System.out.println("New List: " + removeDuplicates(arrayList));
  }

  private static void removeWithSet(int[] arr) {
    Set<Integer> set = new HashSet<>();

    for (int value : arr) {
      set.add(value);
    }

    int[] distinctArry = new int[set.size()];

    int index = 0;

    for (int value : set) {
      distinctArry[index++] = value;
    }

    System.out.println(Arrays.toString(distinctArry));
  }

}
