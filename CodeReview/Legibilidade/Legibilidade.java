package CodeReview.Legibilidade;

public class Legibilidade {

    public static void main(String[] args) {
        int x = 0;
        x = fatorial(x);
    }

    private static int fatorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }
    }
}