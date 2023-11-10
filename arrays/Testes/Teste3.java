package arrays;

/*
 * 
Take two words and check if a third one is the result of interleaving the first two. Take the following
rules into consideration:
1. The number of letters in the third word should be equal to the sum of letters of both words.
2. The letters of the first and second words are not necessarily kept together in the third word,
they can be distributed.
3. The order of the letters in the first two words should not appear changed in the third word. For
example, if we have abc as one of the first two words it cannot appear in the third word
(interleaved or not) as acb or bac.
For example, the following are correctly interleaved words:
airway which is composed of air plus way
package which is composed of pak plus cage. Note that pak letters are not sequential but
interleaved with cage letters
In contrast, the following, are not interleaved according to the rules described above:
car and rib as carib since the ris shared between car and rib thus breaking rule 1.
abc and def as badcef since the order of the letters on abc was not maintained, thus breaking
rule 3.
Write a function:
class Solution { public boolean solution (String S, String T, String U); }
that, given a string S with the first word, a string T with the second word and a string U with the mixed
word, returns a boolean True if the words S and Tare mixed according to the rules described above
or False on the contrary.
You can assume that S, T and U are non-empty words.
In the solution please focus on correctness of the implementation, every string will be of length at
most 25.
 */
public class Teste3 {
    public boolean solution(String S, String T, String U) {

        if (isConsistentLength(S, T, U)) {
            return false;
        }

        int i = 0;
        int j = 0;

        for (char c : U.toCharArray()) {
            if (i < S.length() && c == S.charAt(i)) {
                i++;
            } else if (j < T.length() && c == T.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }

        return i == S.length() && j == T.length();
    }

    private boolean isConsistentLength(String S, String T, String U) {
        return U.length() != S.length() + T.length();
    }

    public static void main(String[] args) {
        Teste3 solution = new Teste3();
        // System.out.println(solution.solution("air", "way", "airway")); // True
        // System.out.println(solution.solution("pak", "cage", "package")); // True
        // System.out.println(solution.solution("car", "rib", "carib")); // False
        System.out.println(solution.solution("abc", "def", "aadcef")); // False
    }

}
