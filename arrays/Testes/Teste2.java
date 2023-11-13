package arrays.Testes;

/*
 * You want to park your bicycle in a bicycle parking area where bike racks are aligned in a row. There
are already N bikes parked there (each bike is attached to exactly one rack, but a rack can have
multiple bikes attached to it). We call racks that already have bikes attached used.
You want to park your bike in a rack in the parking area according to the following criteria:
• the chosen rack must lie between the first and the last used racks (inclusive);
• the distance between the chosen rack and any other used rack is as big as possible.
A description of the bikes already parked in the racks is given in a non-empty zero-indexed array A:
element A[K] denotes the position of the rack to which bike number K is attached (for 0 ≤ K<N). The
central position in the parking area is position 0. A positive value means that the rack is located A[K]
meters to the right of the central position 0; a negative value means that it's located |A[K]| meters to
the left (the absolute value of A[K]).
For example, consider array A such that:
A[0] = 10
A[1] = 0
A[2] = 8
A[3] = 2
A[4] = -1
A[5] = 12
A[6] = 11
A[7] = 3
In the figure below, available racks are represented by dots. Bigger dots represent racks with bikes
attached to them.
10 11 12
You can attach your bike to any rack between rack -1 and rack 12 (including these two racks). In
order to maximize the distance to any used rack, you should attach your bike either to rack 5 or to
rack 6. The resulting distance is 2 meters (from 5 to used rack 3, or from 6 to used rack 8,
respectively).
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A of N integers, returns the largest possible distance in
meters between the chosen rack and any other used rack.
Given array A shown above, the function should return 2, as explained above.
For the following array A:
A[0] = 5
A[1] = 5
the function should return 0, as you can attach your bike only to rack 5.
Write an efficient algorithm for the following assumptions:
. N is an integer within the range [2..100,000];
• each element of array A is an integer within the range [-1,000,000,000..1,000,000,000].
 */
public class Teste2 {
    public static void main(String[] args) {

        int[] A = { 10, 0, 8, 2, -1, 12, 11, 3 };
        int[] A2 = { 10,2,-3,4,5,6 };


        System.out.println(teste(A));

    }

    public static int teste(int[] A) {

        int firstUsedRackIndex = findFirstUsedRackIndex(A);
        int lastUsedRackIndex = findLastUsedRackIndex(A);

        int largestPossibleDistance = 0;

        for (int i = firstUsedRackIndex; i <= lastUsedRackIndex; i++) {
            int distanceToFirstUsedRack = Math.abs(i - firstUsedRackIndex);
            int distanceToLastUsedRack = Math.abs(i - lastUsedRackIndex);

            int distance = Math.min(distanceToFirstUsedRack, distanceToLastUsedRack);

            if (distance > largestPossibleDistance) {
                largestPossibleDistance = distance;
            }
        }

        return largestPossibleDistance;
    }

    private static int findFirstUsedRackIndex(int[] A) {
        int firstUsedRackIndex = 0;
        while (firstUsedRackIndex < A.length && A[firstUsedRackIndex] < 0) {
            firstUsedRackIndex++;
        }
        return firstUsedRackIndex;
    }

    private static int findLastUsedRackIndex(int[] A) {
        int lastUsedRackIndex = A.length - 1;
        while (lastUsedRackIndex >= 0 && A[lastUsedRackIndex] > 0) {
            lastUsedRackIndex--;
        }
        return lastUsedRackIndex;
    }
}
