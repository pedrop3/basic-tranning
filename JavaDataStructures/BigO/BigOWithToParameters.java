package JavaDataStructures.BigO;

public class BigOWithToParameters {
    public static void main(String[] args) {
        printLine(10, 10);
    }

    // O(a + b)
    private static void printLine(int a, int b) {

        // BigO - O(a)
        for (int x = 0; x < a; x++) {
            System.out.println(b);
        }

        // BigO - O(b)
        for (int j = 0; j < b; j++) {
            System.out.println(b);
        }
    }

    // O(a * b)
    private static void printLine2(int a, int b) {

        // BigO - O(a)
        for (int x = 0; x < a; x++) {
            // BigO - O(b)
            for (int j = 0; j < b; j++) {
                System.out.println(b);
            }
        }
    }
}
