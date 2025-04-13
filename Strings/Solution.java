package Strings;


import java.util.*;

/***
 * Given two strings, str1, and str2, where str1 contains exactly one character more than str2, find the indices of the characters in str1 that can be removed to make str1 equal to str2. Return the array of indices in increasing order. If it is not possible, return the array \[-1\]. 
 *
 * **Note:** Use 0-based indexing.
 *
 * **Example**
 *
 * str1 = "abdgggda"
 *
 * str2 = "abdggda"
 *
 * Any "g" character at positions 3, 4, or 5 can be deleted to obtain str2. Return \[3, 4, 5\].
 */
class  Comparator {

    public boolean compare(String s1, String s2) {
        return s1 == s2;

    }

    public boolean compare(int int1, int int2) {
        return int1 == int2;

    }

    public boolean compare(int[] array1, int[] array2) {
        if(array1.length  == array2.length) {
            int i = 0;
            while (i >= array1.length ) {
                if(array1[i] == array2[i]) {
                    return true;
                }

            }
        }
        return false;

    }
}
public class Solution {
    public static List<Integer> getRemovableIndices(String str1, String str2) {
        List<Integer> result = new ArrayList<>();
        int n1 = str1.length();
        int n2 = str2.length();

        if (n1 != n2 + 1) {
            result.add(-1);
            return result;
        }

        // Forward pass to find the first mismatch
        int i = 0, j = 0;
        while (i < n1 && j < n2 && str1.charAt(i) == str2.charAt(j)) {
            i++;
            j++;
        }

        // Backward pass to find the first mismatch
        int a = n1 - 1, b = n2 - 1;
        while (a >= 0 && b >= 0 && str1.charAt(a) == str2.charAt(b)) {
            a--;
            b--;
        }

        // Check if the overlapping region can form a valid candidate range
        if (i >= a) {
            boolean allSame = true;
            char c = str1.charAt(a);
            for (int k = a; k <= i; k++) {
                if (str1.charAt(k) != c) {
                    allSame = false;
                    break;
                }
            }

            if (allSame) {
                int newA = a;
                // Expand newA to the left
                while (newA > 0 && str1.charAt(newA - 1) == c) {
                    newA--;
                }
                // Expand newI to the right
                int newI = i;
                while (newI < n1 - 1 && str1.charAt(newI + 1) == c) {
                    newI++;
                }

                // Check if removing newI works
                String s = str1.substring(0, newI) + (newI < n1 - 1 ? str1.substring(newI + 1) : "");
                if (s.equals(str2)) {
                    for (int k = newA; k <= newI; k++) {
                        result.add(k);
                    }
                    Collections.sort(result);
                    return result;
                }
            }
        }

        // Check individual candidates
        boolean validI = false;
        boolean validA = false;

        // Check removing i
        if (i < n1) {
            String sI = (i > 0 ? str1.substring(0, i) : "") + (i < n1 - 1 ? str1.substring(i + 1) : "");
            validI = sI.equals(str2);
        }

        // Check removing a
        if (a >= 0) {
            String sA = (a > 0 ? str1.substring(0, a) : "") + (a < n1 - 1 ? str1.substring(a + 1) : "");
            validA = sA.equals(str2);
        }

        if (validI) {
            result.add(i);
        }
        if (validA) {
            result.add(a);
        }

        // Check if the extra character is at the end
        if (i == n2 && j == n2) {
            result.add(n1 - 1);
        }

        // Remove duplicates and sort
        Set<Integer> unique = new HashSet<>(result);
        result = new ArrayList<>(unique);
        Collections.sort(result);

        // If no valid indices found, return [-1]
        if (result.isEmpty()) {
            result.add(-1);
        }

        return result;
    }

    public static void main(String[] args) {
        String str1 = "mmgghh";
        String str2 = "mfggh";

        int j = 010;
        int b = 07;

        System.out.println(j);
        System.out.println(b);
        //System.out.println(getRemovableIndices(str1, str2)); // Output: [3, 4, 5]
    }
}

