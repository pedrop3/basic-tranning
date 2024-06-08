package arrays.quiz;

public class LowHighSwap {

    public static void doIt(int[] z) {
        int temp = z[z.length - 1];
        z[z.length - 1] = z[0];
        z[0] = temp;

    }

    public static void main(String[] args) {
        int[] myArray = { 1, 2, 3, 4, 5 };

        LowHighSwap.doIt(myArray);

        for (int x = 0; x < myArray.length; x++) {
            System.out.println(myArray[x] + " ");
        }
    }

}
