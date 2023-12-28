package arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * For this problem, we have types of queries you can perform on a List:
 * 
 * Insert at index :
 * 
 * Insert
 * x y
 * Delete the element at index :
 * 
 * Delete
 * x
 * Given a list, , of integers, perform queries on the list. Once all queries
 * are completed, print the modified list as a single line of space-separated
 * integers.
 * 
 * Input Format
 * 
 * The first line contains an integer, (the initial number of elements in ).
 * The second line contains space-separated integers describing .
 * The third line contains an integer, (the number of queries).
 * The subsequent lines describe the queries, and each query is described over
 * two lines:
 * 
 * If the first line of a query contains the String Insert, then the second line
 * contains two space separated integers , and the value must be inserted into
 * at index .
 * If the first line of a query contains the String Delete, then the second line
 * contains index , whose element must be deleted from .
 * Constraints
 * 
 * 
 * 
 * Each element in is a 32-bit integer.
 * Output Format
 * 
 * Print the updated list as a single line of space-separated integers.
 * 
 * Sample Input
 * 
 * 5
 * 12 0 1 78 12
 * 2
 * Insert
 * 5 23
 * Delete
 * 0
 * Sample Output
 * 
 * 0 1 78 12 23
 */
public class JavaList {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            String operation = scanner.next();

            ListOperation operationFactory = ListOperationFactory.createOperation(operation);
            operationFactory.execute(list, scanner);

        }

        for (Integer num : list) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    @FunctionalInterface
    public interface ListOperation {
        void execute(List<Integer> list, Scanner scanner);
    }

    /**
     * Concrete strategy for inserting an element
     */
    public static class InsertOperation implements ListOperation {

        @Override
        public void execute(List<Integer> list, Scanner scanner) {
            int index = scanner.nextInt();
            int value = scanner.nextInt();
            list.add(index, value);
        }
    }

    /**
     * Concrete strategy for deleting an element
     */
    public static class DeleteOperation implements ListOperation {
        @Override
        public void execute(List<Integer> list, Scanner scanner) {
            int index = scanner.nextInt();
            list.remove(index);
        }
    }

    /**
     * Factory to create operations based on the operation string
     */
    public static class ListOperationFactory {
        private static final Map<String, ListOperation> operationMap = new HashMap<>();

        static {
            operationMap.put("Insert", new InsertOperation());
            operationMap.put("Delete", new DeleteOperation());
        }

        public static ListOperation createOperation(String operation) {
            return operationMap.get(operation);
        }
    }

}
