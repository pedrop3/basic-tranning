package JavaDataStructures.BigO;

public class DropNoDominants {

    public static void main(String[] args) {
        printLine(10);
    }

    // O(n^2) + O(n) "is irrelevant" => O(n^2)
    private static void printLine(int n) {

        // BigO - n * n = O(n^2)
        for (int x =0 ; x < n; x++){
            for (int j =0 ; j < n; j++){
                System.out.println(x + " " +j);
            }
        }

        // O(n)
        for (int k =0 ; k < n; k++){
            System.out.println(k);
        }



    }
}
