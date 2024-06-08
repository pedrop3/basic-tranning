package Strings.StringManipulation;

/**
 * A student is taking a cryptography class and has found anagrams to be very
 * useful. Two strings are anagrams of each other if the first string's letters
 * can be rearranged to form the second string. In other words, both strings
 * must contain the same exact letters in the same exact frequency. For example,
 * bacdc and dcbac are anagrams, but bacdc and dcbad are not.
 * 
 * The student decides on an encryption scheme that involves two large strings.
 * The encryption is dependent on the minimum number of character deletions
 * required to make the two strings anagrams. Determine this number.
 */
public class Anagrams {

    public static void main(String[] args) {
        var stringA = "cde";
        var stringB = "dcf";
        System.out.println("Case 1: " + makeAnagram(stringA, stringB));

        var stringC =  "fcrxzwscanmligyxyvym";
        var stringD =   "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        System.out.println("Case 2: " + makeAnagram(stringC, stringD));


    }

    /**
     * How the Code Works:
     * Character Frequency Count: Two arrays charCountA and charCountB are used to
     * store the frequency of each character in the strings a and b respectively.
     * Populate Frequency Arrays: We iterate through each character of the strings a
     * and b to populate the frequency arrays.
     * Calculate Deletions: We calculate the absolute difference in frequencies for
     * each character from 'a' to 'z' and sum these differences. This sum gives the
     * minimum number of deletions required to make the two strings anagrams.
     * Main Method: The main method takes input strings a and b from the user and
     * prints the result by calling makeAnagram.
     * 
     * Example:
     * For the strings "cde" and "dcf":
     * 
     * Frequencies in a (cde): c -> 1, d -> 1, e -> 1
     * Frequencies in b (dcf): c -> 1, d -> 1, f -> 1
     * Differences: e -> 1, f -> 1 (total deletions = 2)
     */
    public static int makeAnagram(String a, String b) {
        int[] charCountA = new int[26];
        int[] charCountB = new int[26];

        // Count frequency of each character in string a
        for (char c : a.toCharArray()) {
            charCountA[c - 'a']++;
        }

        // Count frequency of each character in string b
        for (char c : b.toCharArray()) {
            charCountB[c - 'a']++;
        }

        int deletions = 0;

        // Calculate the number of deletions required
        for (int i = 0; i < 26; i++) {
            deletions += Math.abs(charCountA[i] - charCountB[i]);
        }

        return deletions;
    }
}
