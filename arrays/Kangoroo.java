package arrays;

public class Kangoroo {

    // I need check if aninal will be math in same possition in future
    // I have inicial value and the pointer to sum
    // x1 = 0 -> 2
    // x2 = 5 -> 3
    // X1 / 0 + 2 = 2 > 2 + 2 = 4 -> 4 + 2 = 6
    // X2 / 4 + 2 = 6 > 6 + 2 = 8
    public static void main(String[] args) {
        int x1 = 0;
        int x2 = 4;
        int v1 = 3;
        int v2 = 2;

        // int x1 = 28;
        // int x2 = 96;
        // int v1 = 8;
        // int v2 = 2;
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        // Check if the kangaroos start at the same position with the same speed
        if (x1 == x2 && v1 == v2) {
            return "YES";
        }

        // Check if the kangaroos have the same relative speed
        if (v1 == v2) {
            return "NO";
        }

        // Check if the relative starting position is divisible evenly by the relative
        // speed
        if ((x2 - x1) % (v1 - v2) == 0 && (x2 - x1) / (v1 - v2) >= 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
