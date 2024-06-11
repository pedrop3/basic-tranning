package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//todo dont woriking
public class TagContentExtractor {

    public static void main(String[] args) {

        // Scanner in = new Scanner(System.in);
        // int testCases = Integer.parseInt(in.nextLine());

        String a = "<h1>Nayeem loves counseling</h1>";
        String b = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        String c = "<Amee>safat codes like a ninja</amee>";
        String d = "<SA premium>Imtiaz has a secret crush</SA premium>";

        // Nayeem loves counseling
        // Sanjay has no watch
        // So wait for a while
        // None
        // Imtiaz has a secret crush



        List<String> listWord = new ArrayList<>();

        listWord.add(a);
        listWord.add(b);
        listWord.add(c);
        listWord.add(d);

        // while (testCases > 0) {
        // String line = in.nextLine();
        // listWord.add(a);
        // listWord.add(b);
        // listWord.add(c);
        // listWord.add(d);
        // testCases--;
        // }

        listWord.forEach(word -> {
            System.out.println(parseTags(word)); 
        });

    }

    private static void extractValidContents(String line) {

        Pattern pattern = Pattern.compile("<([a-zA-Z]+)[^>]*>[^<]*</\\1>");
        Matcher matcher = pattern.matcher(line);

        // Check for valid tags and print contents
        while (matcher.find()) {
                System.out.println(matcher.group(2));
        }

        // If no valid content is found, print None
        if (!matcher.find()) {
            System.out.println("None");
        }
    }

    private static String parseTags(String line) {
    StringBuilder builder = new StringBuilder();
    Stack<String> tags = new Stack<>();
    boolean valid = true;

    for (int i = 0; i < line.length(); i++) {
        char c = line.charAt(i);
        if (c == '<') {
            int end = line.indexOf('>', i + 1);
            if (end == -1) {
                valid = false;
                break;
            }

            String tag = line.substring(i + 1, end);
            if (tag.startsWith("/")) {
                if (tags.isEmpty() || !tags.peek().equals(tag.substring(1))) {
                    valid = false;
                    break;
                }
                tags.pop();
            } else {
                tags.push(tag);
            }
        } else if (c == '>') {
            if (!valid) {
                break;
            }

            if (tags.isEmpty()) {
                builder.append(c);
            } else {
                String tag = tags.pop();
                if (tag.startsWith("/")) {
                    continue;
                }

               // builder.append(line.substring(i + 1, end));
            }
        } else {
            if (!valid || !tags.isEmpty()) {
                continue;
            }

            builder.append(c);
        }
    }

    if (valid && tags.isEmpty()) {
        return builder.toString();
    } else {
        return "None";
    }
}
}

