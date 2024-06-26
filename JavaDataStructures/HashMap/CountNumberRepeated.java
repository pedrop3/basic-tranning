package JavaDataStructures.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Escreva uma função que receba uma lista de números inteiros e retorne um mapa com a contagem de cada número presente na lista.
public class CountNumberRepeated {

  public static Map<Integer, Integer> countNumbers(List<Integer> list) {
    Map<Integer, Integer> countNumberList = new HashMap<>();

    list.forEach(number -> {
      if (!countNumberList.containsKey(number)) {
        countNumberList.put(number, 1);
      } else {
        int value = countNumberList.get(number);
        countNumberList.put(number, value + 1);
      }
    });

    return countNumberList;
  }

  public static Map<Integer, Integer> refector(List<Integer> list) {
    Map<Integer, Integer> countNumberList = new HashMap<>();

    list.forEach(number -> 
        countNumberList.compute(number, (key, value) -> (value == null) ? 1 : value + 1));

    return countNumberList;

  }

  public static void main(String[] args) {
    List<Integer> arrayList = Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6, 6, 6);

    System.out.println("Old List:              " + arrayList);
    System.out.println("New List:              " + countNumbers(arrayList));
    System.out.println("New List with  compute " + countNumbers(arrayList));

  }
}
