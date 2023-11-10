package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicationWord {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());

        List<String> wordList = new ArrayList<>();

        while (testCases > 0) {
            String word = scanner.nextLine();
            wordList.add(word);
            testCases--;

        }

        regex(wordList);

        scanner.close();

    }

    public static void regex(List<String> wordList) {

        // var list =
        // wordList.stream().map(String::toLowerCase).distinct().collect(Collectors.toList());

        for (String word : wordList) {
            String pattern = "\\b(\\w+)(\\b\\W+\\1\\b)*";
            Pattern r = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);

            Matcher m = r.matcher(word);

            while (m.find()) {
                word = word.replaceAll(m.group(), m.group(1));
            }

            System.out.println(word);
        }

    }

}
