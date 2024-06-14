package JavaDataStructures.HashMap;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RansomNote {

        public static void main2(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        checkMagazine(magazine, note);

        bufferedReader.close();
    }
    public static void main(String[] args) throws IOException {

        List<String> magazine = Arrays.asList("ive", "got", "a", "lovely", "bunch", "some", "coconuts");
           

        List<String> note = Arrays.asList("ive", "got", "some", "is", "coconuts");

        checkMagazine(magazine, note);

    }

    public static boolean checkMagazine2(List<String> magazine, List<String> note) {

        for (String noteWord : note) {

            long countMagazineWord = magazine.stream().filter(magazineWord -> magazineWord.equals(noteWord)).count();
            long countNoteWord = note.stream().filter(filterWord -> filterWord.equals(noteWord)).count();

            if (countMagazineWord != countNoteWord) {
                return false;
            }

        }
        return true;

    }

    public static void checkMagazine(List<String> magazine, List<String> note) {

        Map<String, Integer> magazineMap = new HashMap<>();


        for (String magazineWord : magazine) {
            magazineMap.put(magazineWord, magazineMap.getOrDefault(magazineMap, 0) + 1);
        }

         Map<String, Integer> noteMap = new HashMap<>();


        for(String noteWord : note) {
            noteMap.put(noteWord, noteMap.getOrDefault(noteMap, 0) + 1);
        }

        boolean canFormRansomNote = true;
        
        for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
            String word = entry.getKey();
            int ransomCount = entry.getValue();

            if (!magazineMap.containsKey(word) || magazineMap.get(word) < ransomCount) {
                canFormRansomNote = false;
                break;
            }
        }
        List<String> nomes = new ArrayList<>();
        nomes.add("Pedro");
        nomes.add("Caulo");
        Collections.sort(nomes);

        System.out.println(canFormRansomNote ? "Yes" : "No");
       

    }
}
