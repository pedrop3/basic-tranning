import java.util.Arrays;

public class MaxValue {

  public static int findMaxElements(int[] arr) {

    int max = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    return max;
  }

  public static int findMaxElementsByStream(int[] arr) {
   return Arrays
        .stream(arr)
        .max()
        .getAsInt();
    
  }

  public static void main(String[] args) {
    int[] arr = { 5, 8, 2, 10, 55, 50, 888, 3 };
    int maxElement = findMaxElementsByStream(arr);

    System.out.println("MaxElement is " + maxElement);
  }
}
