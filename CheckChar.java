import java.util.Arrays;
import java.util.stream.IntStream;

public class CheckChar {

  public static boolean isLetterPresent(char[] arr, char target) {

    for (char c : arr) {
      if (c == target) {
        return true;
      }
    }
    return false;
  }

  public static boolean isLetterPresenStream(char[] arr, char target) {

    return IntStream.range(0,arr.length)
      .mapToObj(i->arr[i])
      .anyMatch(c->c==target);

  }

  public static void main(String[] args) {  
      char[] charArray = {'a', 'b', 'c', 'd', 'e'};
      char target = 'g';
      boolean isPresent = isLetterPresenStream(charArray, target);
      System.out.println("A letra '" + target + "' está presente no Char[]? " + isPresent);
    }
}
