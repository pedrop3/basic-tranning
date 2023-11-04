package arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Sometimes it's better to use dynamic size arrays. Java's Arraylist can
 * provide you this feature. Try to solve this problem using Arraylist.
 * 
 * You are given lines. In each line there are zero or more integers. You need
 * to answer a few queries where you need to tell the number located in position
 * of line.
 * 
 * Take your input from System.in.
 * 
 * Input Format
 * The first line has an integer . In each of the next lines there will be an
 * integer denoting number of integers on that line and then there will be
 * space-separated integers. In the next line there will be an integer denoting
 * number of queries. Each query will consist of two integers x and y.
 * 
 * 
 * Sample Input
 * 
 * 5
 * 5 41 77 74 22 44
 * 1 12
 * 4 37 34 36 52
 * 0
 * 3 20 22 33
 * 5
 * 1 3
 * 3 4
 * 3 1
 * 4 3
 * 5 5
 * Sample Output
 * 
 * 74
 * 52
 * 37
 * ERROR!
 * ERROR!
 */
public class ArrayListByKey {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner scanner = new Scanner(System.in);

        // System.out.println("Quantidade de linhas");
        int totalLine = scanner.nextInt();

        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        for (int i = 0; i < totalLine; i++) {

            // System.out.println("Quantidade de numeros no linha " + i);
            int lineSize = scanner.nextInt();

            ArrayList<Integer> line = new ArrayList<>();

            for (int j = 0; j < lineSize; j++) {

                // System.out.println("Escreva o total de" + lineSize + " numeros na linha " + i
                // + " total " + j);
                line.add(scanner.nextInt());
            }

            lines.add(line);

        }

        // System.out.println("Quais querys vc quer fazer ? x e y");
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (x <= lines.size() && y <= lines.get(x - 1).size()) {
                System.out.println(lines.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }

        }

    }
}