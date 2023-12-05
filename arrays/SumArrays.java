package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumArrays {

    public static void main(String[] args) {

        List<Integer> ar = new ArrayList<>(Arrays.asList(1,2, 3, 4,10,11));

        int sum = simpleArraySum(ar);

        System.out.println(sum);
        
    }
    

       public static int simpleArraySum(List<Integer> ar) {
        var check = ar.contains(100);

        return ar.stream().reduce(Integer::sum).orElseThrow();


     

    }
}
