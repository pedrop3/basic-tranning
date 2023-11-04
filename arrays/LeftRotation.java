package arrays;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. Given an integer, , rotate the array that many steps left and return the result.

Example


After  rotations, .

Function Description

Complete the rotateLeft function in the editor below.

rotateLeft has the following parameters:

int d: the amount to rotate by
int arr[n]: the array to rotate
Returns

int[n]: the rotated array
Input Format

The first line contains two space-separated integers that denote , the number of integers, and , the number of left rotations to perform.
The second line contains  space-separated integers that describe .

Constraints

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

To perform  left rotations, the array undergoes the following sequence of changes:
 */
public class LeftRotation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int rotation = Integer.parseInt(firstMultipleInput[0]);

        // int rotation = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> listNumber = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = rotLeft(listNumber, rotation);
        List<Integer> result2 = rotLeft2(listNumber, rotation);

        System.out.println(result);
        System.out.println(result2);

        bufferedReader.close();
    }

    public static List<Integer> rotLeft(List<Integer> listNumber, int d) {

        List<Integer> rotatedList = new ArrayList<>();

        d = d % listNumber.size();

        // Rotate the list by one position.
        for (int i = d; i < listNumber.size(); i++) {
            int value = listNumber.get(i);
            rotatedList.add(value);
        }
        for (int i = 0; i < d; i++) {
            rotatedList.add(listNumber.get(i));
        }

        return rotatedList;
    }

    public static List<Integer> rotLeft2(List<Integer> listNumber, int d) {

        int n = listNumber.size();
        d = d % n;

        // Use a stream to rotate the list to the left
        List<Integer> rotatedList = listNumber.stream()
                .skip(d)
                .collect(Collectors.toList());

        rotatedList.addAll(listNumber.stream().limit(d).collect(Collectors.toList()));

        return rotatedList;

    }

}
