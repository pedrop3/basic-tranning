import java.util.Arrays;

public class CheckChar {

  public static boolean isLetterPresent(char[] arr, char target) {

    for (char c : arr ) {
        if (c == target) {
            return true;
        }
    }
    return false;

  }


  public static void main(String[] args) {  
      char[] charArray = {'a', 'b', 'c', 'd', 'e'};
      char target = 'c';
      boolean isPresent = isLetterPresent(charArray, target);
      System.out.println("A letra '" + target + "' está presente no Char[]? " + isPresent);
    }
}
