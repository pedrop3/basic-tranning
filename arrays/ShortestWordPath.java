package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ShortestWordPath {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // String source = scanner.nextLine();
    // String target = scanner.nextLine();
    // String[] words = scanner.nextLine().split(" ");
    String source = "bit";
    String target = "dog";
    String[] words = {"but", "put", "big", "pot", "pog", "dog", "lot"};

    int transactions = shortestWordEditPath(source, target, words);
    System.out.println(transactions);

    scanner.close();

  }

  static int shortestWordEditPath(String source, String target, String[] words) {

    Set<String> wordSet = new HashSet<>(Arrays.asList(words));
    Queue<String> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    queue.offer(source);
    visited.add(source);
    int steps = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String currentWord = queue.poll();

            
            if (currentWord.equals(target)) {
                return steps;
            }

            for (int j = 0; j < currentWord.length(); j++) {
                char[] charArray = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charArray[j] = c;
                    String transformedWord = new String(charArray);
                    if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                        queue.offer(transformedWord);
                        visited.add(transformedWord);
                    }
                }
            }
        }
        steps++;
    }

    return -1; // If no transformation is possible
  }
}
