package arrays.quiz;

public class LowHighSwap2 {

    public static void doIt(int[] z) {
        z[0] =  z[z.length - 1];
    }

    public static void main(String[] args) {
        int[] myArray = { 1, 2, 3, 4, 5 };

        LowHighSwap2.doIt(myArray);

        for (int x = 0; x < myArray.length; x++) {
            System.out.println(myArray[x] + " ");
        }
    }

}
