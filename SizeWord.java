
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Escreva uma função que receba uma lista de strings e retorne a maior palavra presente na lista.
public class SizeWord {

  public static void main(String[] args) {
    List<String> list = Arrays.asList("a", "banana", "appLe", "orangerrrrrr", "apple", "grape");

    String bigger = findBiggerWord(list);
    
    String shortWord = findShortWord(list);

    System.out.println("bigger " + bigger );
    System.out.println("short " + shortWord);
  }


  public static String findBiggerWord(List<String> list) {
    return list.stream()
      .max(Comparator.comparingInt(String::length))
      .orElse(null);
  }

  public static String findShortWord(List<String> list) {
    return list.stream()
      .min(Comparator.comparingInt(String::length))
      .orElse(null);
  }

}
