package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicates {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 2, 4, 5, 4, 6 };

    List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6));

    System.out.println("Original: " + arrayList);

    System.out.println("Stream:   " + Arrays.toString(getArr2(arr)));

    System.out.println("Set:      " + removeWithSet(arr));
    System.out.println("New List: " + removeDuplicatesStream(arrayList));
  }

  // O(n) - Se você precisa manter a ordem original dos elementos e trabalhar com arrays, o método getArr2 pode ser uma boa escolha.
  private static int[] getArr2(int[] arr) {
    int[] arr2 = Arrays.stream(arr).distinct().toArray();
    return arr2;
  }


  //O(n) - Se a ordem não é importante e você está trabalhando com arrays, removeWithSet é uma opção eficiente.
  private static Set<Integer> removeWithSet(int[] arr) {
    Set<Integer> unique = new HashSet<>();

    for (Integer value : arr) {
      unique.add(value);
    }

    return unique;
  }

  // O (n) - Se você está trabalhando com listas e quer manter a ordem original, o método removeDuplicatesStream pode ser mais conveniente.
  public static List<Integer> removeDuplicatesStream(List<Integer> list) {
    return list.stream().distinct().collect(Collectors.toList());
  }
}
