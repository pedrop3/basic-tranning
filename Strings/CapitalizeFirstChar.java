package Strings;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Assume you are working at a newspaper. Your task is to prepare a page with
 * titles that writers send you. Your cat was walking over your keyboard and
 * accidentally added characters. Now you need to filter out the titles and
 * prepare them for publishing.
 * Assume that titles are in an array of strings. You need to do the following
 * procedures on it:
 * 
 * Create a single string by concatenating the strings in the array
 * Delete all numeric symbols from the string
 * Capitalize the first character of each word in the string
 * 
 **/
public class CapitalizeFirstChar {

  public static void main(String[] argh) {

    List<String> list1 = Arrays.asList("breac3king news", "1A 1circle is round!");

    StringBuilder concatenatedString = new StringBuilder();

    for (String title : list1) {
      concatenatedString.append(title);
    }

    String output = concatenatedString.toString().replaceAll("[0-9]", "");
    System.out.println(capitalizeFirstChar(output));

  }

  private static String capitalizeFirstChar(String output) {
    StringBuilder titleCase = new StringBuilder();

    boolean nextTitleCase = true;

    for (char c : output.toCharArray()) {
      if (Character.isSpaceChar(c)) {
        nextTitleCase = true;
      } else if (nextTitleCase) {
        c = Character.toTitleCase(c);
        nextTitleCase = false;
      } else {
        c = Character.toLowerCase(c);
      }

      titleCase.append(c);
    }

    return titleCase.toString();
  }

}
