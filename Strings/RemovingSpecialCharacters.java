package Strings;
/**
 * 
 * You are developing a data cleaning tool. You receive a list of text data, but
 * it contains special characters that need to be removed. Your task is to
 * filter out these special characters and prepare the text for analysis.
 * 
 * Assume that the text data is in an array of strings. You need to do the
 * following procedures on it:
 * 
 * Create a single string by concatenating the strings in the array.
 * Delete all special characters (e.g., punctuation marks, symbols) from the
 * string.
 **/
public class RemovingSpecialCharacters {

  public static void main(String[] argh) {

    String[] textData = {
        "This is some text with special characters: !@#$%^&*()",
        "Another string: [{}]~`-_=+",
        "And one more: <>?/\\"
    };

    String text = String.join(" ", textData);

    removeSpecialCharacters(text);

  }

  private static void removeSpecialCharacters(String text) {
    String regex = "[^a-zA-Z0-9\\s]+";

    String cleanText = text.replaceAll(regex, "");

    System.out.println(cleanText);

    

  }

}
