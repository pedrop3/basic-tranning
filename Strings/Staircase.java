package Strings;
import java.io.IOException;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {

    }

}

public class Staircase {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // int n = Integer.parseInt(bufferedReader.readLine().trim());


        staircase(5);

        // bufferedReader.close();
    }

    public static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
    
            System.out.println();
        }

    }
}
