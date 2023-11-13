package arrays.Testes;

import java.util.HashMap;
import java.util.Map;

public class Teste123 {
    public static void main(String[] args) {
        String A = "RSPRS";
        String B = "SRR";
        String C = "PRPRRPP";
        String D = "PPPPRRSSSSS";
        System.out.println(teste(A));
        System.out.println(teste(B));
        System.out.println(teste(C));
        System.out.println(teste(D));

    }

    public static int teste(String G) {

        int maxPoints = 0;

        for (char move : new char[] { 'R', 'P', 'S' }) {
            int points = 0;
            for (int i = 0; i < G.length(); i++) {
                if (move == G.charAt(i)) {
                    points++;
                } else if (move == 'R' && G.charAt(i) == 'S') {
                    points += 2;
                } else if (move == 'S' && G.charAt(i) == 'P') {
                    points += 2;
                } else if (move == 'P' && G.charAt(i) == 'R') {
                    points += 2;
                }
            }

            maxPoints = Math.max(maxPoints, points);
        }

        return maxPoints;
    }

     public static int teste1(String G) {

        Map<Character, Integer> pointsMap = new HashMap<>();
        pointsMap.put('R', 0);
        pointsMap.put('P', 0);
        pointsMap.put('S', 0);
    
        for (char c : G.toCharArray()) {
            switch (c) {
                case 'R':
                    pointsMap.put('R', pointsMap.get('R') + 1);
                    break;
                case 'P':
                    pointsMap.put('P', pointsMap.get('P') + 1);
                    break;
                case 'S':
                    pointsMap.put('S', pointsMap.get('S') + 1);
                    break;
            }
        }
    
        int maxPoints = 0;
        for (Character move : pointsMap.keySet()) {
            maxPoints = Math.max(maxPoints, pointsMap.get(move));
        }
    
        return maxPoints;
    }

    private static char getWinningGesture(char chosenGesture, char giovanniGesture) {
        if (chosenGesture == 'R' && giovanniGesture == 'S') {
            return 'R';
        } else if (chosenGesture == 'P' && giovanniGesture == 'R') {
            return 'P';
        } else if (chosenGesture == 'S' && giovanniGesture == 'P') {
            return 'S';
        } else {
            return giovanniGesture;
        }
    }

    private static int processPointsFranco(String G, int n, char francoGesture) {
        int francoPoints = 0;
        for (int i = 0; i < n; i++) {
            char giovanniGesture = G.charAt(i);

            if (francoGesture == giovanniGesture) {
                francoPoints += 1;
            } else if ((francoGesture == 'R' && giovanniGesture == 'S') ||
                    (francoGesture == 'P' && giovanniGesture == 'R') ||
                    (francoGesture == 'S' && giovanniGesture == 'P')) {
                francoPoints += 2;
            }
        }
        return francoPoints;
    }
}
