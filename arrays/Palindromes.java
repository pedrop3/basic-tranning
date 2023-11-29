package arrays;

public class Palindromes {

    public static void main(String[] args) {

        System.out.println(highestValuePalindrome("11331", 5, 4));
        // "3993" one time - k = 1

    }

    public static String highestValuePalindrome(String s, int n, int k) {

        int changes = 0;
        char[] arr = s.toCharArray();

        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) {
                if (arr[i] > arr[j] && k > 0) {
                    arr[j] = arr[i];
                    changes++;
                } else if (arr[i] < arr[j] && k > 0) {
                    arr[i] = arr[j];
                    changes++;
                } else {
                    return "-1";
                }
            }
        }

        if (changes > k) {
            return "-1";
        }

        int mid = n / 2;
        if (changes < k && n % 2 == 1) {
            arr[mid] = '9';
            changes++;
        }

        for (int i = 0, j = n - 1; i < mid && j > mid; i++, j--) {
            if (arr[i] < '9' && changes < k) {
                arr[i] = arr[j] = '9';
                changes += 2;
            } else if (arr[i] == '9' && arr[j] == '9' && changes < k) {
                arr[i] = arr[j] = '9';
                changes++;
            }
        }

        return String.valueOf(arr);
    }
}