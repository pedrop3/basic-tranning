package Strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 
 * You are developing an email extraction tool. You receive a list of text data,
 * and you need to extract all the email addresses from it. Your task is to
 * identify and extract the email addresses.
 * 
 * Assume that the text data is in an array of strings. You need to do the
 * following procedures on each string:
 * 
 * Identify and extract all valid email addresses.
 **/
public class ExtractingEmailAddresses {

  public static void main(String[] argh) {

    ArrayList<String> dataText = new ArrayList<>(Arrays.asList("teste", "pedor@email.com", "eodr", "pedro@email.com"));

    ArrayList<String> clearText = dataText
        .stream()
        .filter(p -> p.contains("@"))
        .collect(Collectors.toCollection(ArrayList::new));

    System.out.println(clearText.toString());

    String[] textData = {
        "Here is an example email address: john.doe@example.com",
        "Please contact support@company.com for assistance.",
        "Invalid email: this_is_not_an_email",
        "Another valid email: alice.smith@example.co.uk",
        "Invalid : pedro@email"
    };

    List<String> extractedEmails = extractEmails(textData);

    System.out.println("Extracted email addresses:");
    
    for (String email : extractedEmails) {
      System.out.println(email);
    }
  }

  public static List<String> extractEmails(String[] textData) {
    List<String> extractedEmails = new ArrayList<>();

    Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,7}\\b");

    for (String text : textData) {
      Matcher matcher = emailPattern.matcher(text);
      while (matcher.find()) {
        extractedEmails.add(matcher.group());
      }
    }

    return extractedEmails;
  }

}
