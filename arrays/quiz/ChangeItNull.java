package arrays.quiz;

public class ChangeItNull {

    public static void doIt(int[] z) {
        z = null;
    }

    public static void main(String[] args) {

        int[] myArray2 = { 1, 2, 3, 4, 5 };

        ChangeItNull.doIt(myArray2);
        for (int x = 0; x < myArray2.length; x++) {
            System.out.println(myArray2[x] + " ");
        }
    }

}
