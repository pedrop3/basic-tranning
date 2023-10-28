package Datas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * 
 * Write a program that reads two dates and prints the difference between the
 * two dates in days, weeks, months and years.
 **/
public class BetweenTwoDates {


  public static void main(String[] argh) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a primeira data (formato: DD/MM/AAAA): ");
    String firstDate = scanner.nextLine();

    System.out.println("Digite a primeira data  (formato: DD/MM/AAAA): ");
    String secondDate = scanner.nextLine();

    scanner.close();

    LocalDate date1 = formatLocalDate(firstDate);
    LocalDate date2 = formatLocalDate(secondDate);

    processDiffDates(date1, date2);

  }

 

  private static LocalDate formatLocalDate(String stringDate) {
    DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(stringDate, sourceFormatter);

    DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    return LocalDate.parse(localDate.format(targetFormatter));
  }

  private static void processDiffDates(LocalDate date1, LocalDate date2) {

    long daysDiff = ChronoUnit.DAYS.between(date1, date2);
    long weeksDiff = ChronoUnit.WEEKS.between(date1, date2);
    long monthsDiff = ChronoUnit.MONTHS.between(date1, date2);
    long yearsDiff = ChronoUnit.YEARS.between(date1, date2);

    System.out.println("Diferença em dias: " + daysDiff);
    System.out.println("Diferença em semanas: " + weeksDiff);
    System.out.println("Diferença em meses: " + monthsDiff);
    System.out.println("Diferença em anos: " + yearsDiff);
  }


}
