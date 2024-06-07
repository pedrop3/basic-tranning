package Strings.StringManipulation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Sherlock considers a string to be valid if all characters of the string
 * appear the same number of times. It is also valid if he can remove just 1
 * character at index 1 in the string, and the remaining characters will occur
 * the same number of times. Given a string , determine if it is valid. If so,
 * return YES, otherwise return NO.
 * 
 * Sample Input 0
 * 
 * aabbcd
 * Sample Output 0
 * 
 * ---
 * NO
 * 
 * Sample Input 2
 * 
 * abcdefghhgfedecba
 * Sample Output 2
 * 
 * YES
 */
public class SherlockAndValidString {

    public static void main(String[] args) {
        String A = "abbcccdddd";
        System.out.println("YES:" + isValid(A));

    }

    /**
     * How the code works:
     * In tackling this issues, we operate within the realm of the alphbet, where
     * arrays are limited to a
     * length 26. The solution involves crafting a loop to tally the occurrences of
     * each letter within the string.
     * Upon detecting an index count exceeding 2, we increment the deletion count
     * variable.
     * 
     * O(n)
     * 
     * Exempl:
     * Frequencies in a (aabbcd): a -> 2, b-> 2, c -> 1, d -> 1
     * return "NO"
     * Explanation:
     * We would need to remove two char, both
     * c and d -> aabb
     * a and b-> abcd, to make it valid.
     * 
     * 
     * Key and Value
     * Data Struturs: Map
     * 
     */
    public static String isValid(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        
        // Contar a frequência de cada caractere
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        
        // Contar a frequência das frequências
        for (int frequency : charFrequency.values()) {
            frequencyCount.put(frequency, frequencyCount.getOrDefault(frequency, 0) + 1);
        }
        
        // Verificar condições de validade
        if (frequencyCount.size() == 1) {
            return "YES";
        }
        
        if (frequencyCount.size() == 2) {
            int f1 = (int) frequencyCount.keySet().toArray()[0];
            int f2 = (int) frequencyCount.keySet().toArray()[1];
            int count1 = frequencyCount.get(f1);
            int count2 = frequencyCount.get(f2);
            
            // Caso uma frequência seja 1 e ocorra uma vez (podemos remover este caractere)
            if ((f1 == 1 && count1 == 1) || (f2 == 1 && count2 == 1)) {
                return "YES";
            }
            
            // Caso a diferença entre as frequências seja 1 e a maior ocorra apenas uma vez
            if ((Math.abs(f1 - f2) == 1) && ((count1 == 1 && f1 > f2) || (count2 == 1 && f2 > f1))) {
                return "YES";
            }
        }
        
        return "NO";

    }

}
