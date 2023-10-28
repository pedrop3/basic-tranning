import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicates {

  public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
    return list.stream()
        .distinct()
        .collect(Collectors.toCollection(ArrayList::new));
  }



  public static void main(String[] args) {
      int[] arr = {1, 2, 3, 2, 4, 5, 4, 6};


       int[] arr2 = Arrays.stream(arr).distinct().toArray();

      ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 5, 4, 6));


      System.out.println("List: " + Arrays.toString(arr2));
      System.out.println("Old List: " + arrayList);
      System.out.println("New List: " + removeDuplicates(arrayList));
    }
}
