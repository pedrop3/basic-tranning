import java.util.Scanner;

public class SumWithAst {
  static int valueA;
  static int valueB;

  static {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite o valor 1:");
    valueA = scanner.nextInt();
    System.out.println("Digite o valor 2:");
    valueB = scanner.nextInt();
    scanner.close();


  }

  public static void main(String[] args) {

    int total = 0;
    for (int i = 0; i < valueB; i++) {
      total = total + valueA;
    }
      
    System.out.println("Total:" + total);
  }
}
