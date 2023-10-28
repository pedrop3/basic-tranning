package HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Escreva uma função que receba uma lista de números inteiros e retorne um mapa com a contagem de cada número presente na lista.
public class CountNumberRepeated {

  public static  Map<Integer, Integer> countNumbers(List<Integer> list) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int number : list) {
      if (!counts.containsKey(number)) {
        counts.put(number, 1);
      } else {
        counts.put(number, counts.get(number) + 1);
      }
    }
    return counts;

  }

  public static void main(String[] args) {  
      ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6));

      System.out.println("Old List: " + arrayList);
      System.out.println("New List: " + countNumbers(arrayList));
    }
}
