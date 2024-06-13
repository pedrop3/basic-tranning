package JavaDataStructures.BigO;

public class DropConstants {

    public static void main(String[] args) {
        printLine(10);
    }

    // O(n)
    private static void printLine(int n) {

        // BigO O(n)
        for (int x =0 ; x < n; x++){
            System.out.println(x);
        }

        // BigO O(n)
        for (int j =0 ; j < n; j++){
            System.out.println(j);
        }

        // BigO O(n) -> O(n) + O(n) =  O(2n) => O(n) - To simplification we drop the constants
    }
}
