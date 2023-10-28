package Math;
import java.util.ArrayList;
import java.util.Arrays;

//Implemente uma função que receba uma lista de números e retorne a média dos números.
public class AverageNumber {

  public static Double buildAverageNumbers(ArrayList<Double> list) {

    return list.stream()
        .mapToDouble(Double::doubleValue)
        .average()
        .orElse(0.0);
  }

  public static void main(String[] args) {
    ArrayList<Double> arrayList = new ArrayList<>(Arrays.asList(1.0, 2.3, 3.5, 2.6, 4.7, 5.4));

    System.out.println("Average: " + buildAverageNumbers(arrayList));
  }
}
