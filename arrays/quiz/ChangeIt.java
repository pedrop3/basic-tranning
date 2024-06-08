package arrays.quiz;

public class ChangeIt {


    public static void doIt(int[] z) {
        int[] A = z;
        A[0] = 99;
        
    }
    public static void main(String[] args) {
        
        int[] myArray = {1,2,3,4,5};

        ChangeIt.doIt(myArray);
        for (int x = 0; x < myArray.length; x++) {
            System.out.println(myArray[x] + " ");
        }
    }

}
