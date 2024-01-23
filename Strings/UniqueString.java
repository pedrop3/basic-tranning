package Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueString {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names1) {
            uniqueNames.add(name);
        }

        // for (String name : names2) {
        //     uniqueNames.add(name.equals(uniqueNames));
        // }

        return uniqueNames.toArray(new String[uniqueNames.size()]);

    }

    public static void main(String[] args) {
        String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
        String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
        System.out.println(String.join(", ", uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}