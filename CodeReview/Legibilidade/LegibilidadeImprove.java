package CodeReview.Legibilidade;

public class LegibilidadeImprove {

    public static void main(String[] args) {
        int number = 10;
        int result = calcFactorial(number);

        System.out.println(result);
    }

    private static int calcFactorial(int number) {
        return (number == 0) ? 1 : calculateFactorialLoop(number);
    }

    private static int calculateFactorialLoop(int number) {
        int result = 1;

        for (int i = 2; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}
