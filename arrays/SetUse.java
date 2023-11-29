package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetUse {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Pedro", "pedro", "Ana", "ana", "Claudio", "Cláudio");

        String phase = "A man, a plan, a canal – Panama";

        String result = phase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder reversePhrase = new StringBuilder(result);

        boolean isPoli = result.equals(reversePhrase.reverse().toString());

        System.out.println(isPoli);

        Set<String> unidWord = new HashSet<>(words);
        Set<String> unidWord2 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        unidWord2.addAll(words);

        List<String> names = new ArrayList<>();
        names.add("Ana");
        names.add("Pedro");

        Comparator<String> reverse = Collections.reverseOrder();
        Collections.sort(names, reverse);

        phase.substring(0);

        String texto = " Pedro Henrique Martins dos Santos ";

        String newString = texto.trim();
        System.out.println(newString);

        int startIndex = 0;

        while (startIndex < texto.length() && Character.isWhitespace(texto.charAt(startIndex))) {

            startIndex++;

        }

        int endIndex = texto.length() - 1;
        while (endIndex > startIndex && Character.isWhitespace(texto.charAt(startIndex))) {
            endIndex--;
        }


        String newString2 = texto.substring(startIndex, endIndex + 1);

        System.out.println(unidWord);
        System.out.println(unidWord2);
    }

}
