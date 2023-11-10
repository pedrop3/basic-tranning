package Math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * Given an array of integers, keep a total score based on the following:
 *
 * Add 1 point for every even number in the array
 * Add 3 points for every odd number in the array, except for the number 5
 * Add 5 points for every time you encounter a 5 in the array
 **/
public class ArrayIntegers {

  public static void main(String[] argh) {
    int[] input = { 1, 2, 3, 4, 5 };

    Integer[] input2 = { 17, 19, 21 };

    ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(input2));

    check(input);

    System.out.println(checkPoints(arrayList));

  }

  private final static Integer checkPoints(ArrayList<Integer> arrayList) {

    int points = 0;
    
    if (arrayList.isEmpty()) {
      return points;
    }

    for (int number : arrayList) {
      if (number % 2 != 0) {

        if (number == 5) {
          points += 5;
        } else {
          points += 3;
        }
      } else {
        points += 1;

      }
    }

    return points;
  }

  public static int check(int[] input) {
    int total = 0;
    if (input.length == 0) {
      return total;
    }
    for (int i = 0; i < input.length; i++) {
      int currentNumber = input[i];
      
      if (currentNumber % 2 != 0) {
        if (currentNumber == 5) {
          total += 5;
        } else {
          total += 3;
        }

      } else {
        total += 1;
      }

    }
    return total;
  }
}
