
package Strings.StringManipulation;

/**
 * You are given a string containing characters and only. Your task is to change
 * it into a string such that there are no matching adjacent characters. To do
 * this, you are allowed to delete zero or more characters in the string.
 * 
 * Your task is to find the minimum number of required deletions.
 * 
 * Example
 * 
 * Remove an at positions and to make in deletions.
 * 
 * Function Description
 * 
 * Complete the alternatingCharacters function in the editor below.
 * 
 * alternatingCharacters has the following parameter(s):
 * 
 * string s: a string
 * 
 * Sample Input
 * 
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 * Sample Output
 * 
 * 3
 * 4
 * 0
 * 0
 * 4
 */
public class AlternatingCharacters {

    public static void main(String[] args) {

        String A = "AAAA";
        System.out.println(alternatingCharacters(A));

        String B = "AAABBB";
        System.out.println(alternatingCharacters(B));
    }

    /**
     * How the Code Works:
     * We need to create a loop to iterate through the string and check if the
     * current character is different from the next character.
     * If the next character is the same as the current character, increment the
     * deletion count.
     * 
     * 
     * Example:
     * For the strings String A = "AAAA" and String B = "ABABABAB":
     * 
     * (AAAA)
     * (0) -> A == (1) -> A increment ++
     * (1) -> A == (2) -> A increment ++
     * (2) -> A == (3) -> A increment ++
     * total deletions = 3
     * 
     * (AAABBB)
     * (0) -> A == (1) -> A increment ++
     * (1) -> A == (2) -> A increment ++
     * (2) -> A == (3) -> B SKIP
     * (3) -> B == (4) -> B increment ++
     * (4) -> B == (5) -> B increment ++
     * total deletions = 4
     * 
     * O(n)
     */
    public static int alternatingCharacters(String s) {
        int deletions = 0;

        for (int x = 0; x < s.length() - 1; x++) {
            if (s.charAt(x) == s.charAt(x + 1)) {
                deletions++;
            }

        }
        return deletions;
    }

}
