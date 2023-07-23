import java.util.Arrays;
import java.util.List;

public class CountOccurrences {

  public static long countOccurrences(List<String> list, String target) {

    return  list.stream()
    .map(String::toLowerCase)
    .filter(e -> e.equals(target))
    .count();
  }

  public static void main(String[] args) {  
        List<String> list = Arrays.asList("apple", "banana",  "appLe","orange", "apple", "grape");
        String target = "apple";
        
        long countOccurrences = countOccurrences(list, target);

        System.out.println("countOccurrences " + countOccurrences);
    }
}
