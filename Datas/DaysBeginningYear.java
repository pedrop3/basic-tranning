package Datas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 
Write a program that reads a date and prints the number of days that have passed since the beginning of the year.
 **/
public class DaysBeginningYear {
  public static void main(String[] argh) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite data (formato: DD/MM/AAAA): ");
    String firstDate = scanner.nextLine();

    scanner.close();

    getDaysInYear(formatLocalDate(firstDate));

  }

  private static LocalDate formatLocalDate(String stringDate) {
    DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(stringDate, sourceFormatter);

    DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    return LocalDate.parse(localDate.format(targetFormatter));
  }

  private static void getDaysInYear(LocalDate date) {
    System.out.println("Dias no ano: " + date.getDayOfYear());
  }
}
