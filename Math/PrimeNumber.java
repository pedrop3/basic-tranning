package Math;

// Replace ___ with your code below
import java.util.Scanner;

class Main {
    // function to check if a number is prime
    public static boolean isNumberPrime(int number) {
        // check if number is less than or equal to 1
        if (number <= 1) {
            System.out.println("Not Prime");
            return false;
        }
        // run a loop from 2 to number - 1
        for (int i = 2; i <= (number - 1); i++) {
            // check if i divides the number perfectly
            if (number % i == 0) {
                // the number is not prime
                return false;
            }
        }
        // the number is prime
        return true;
    }

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        // check if the number is prime
        boolean isPrime = isNumberPrime(number);

        // print result based on whether the number is prime or not
        if (isPrime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
}