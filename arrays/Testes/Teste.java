package arrays.Testes;

public class Teste {
    public static void main(String[] args) {
        String G = "RSPRS";
        System.out.println(teste(G));

    }

    public static int teste(String G) {

        int n = G.length();
        if (n == 0) {
            return 0;
        }

        int countRock = 0;
        int countPaper = 0;
        int countScissors = 0;

        for (int i = 0; i < n; i++) {
            char giovanniGesture = G.charAt(i);

            if (giovanniGesture == 'R') {
                countRock++;
            } else if (giovanniGesture == 'P') {
                countPaper++;
            } else if (giovanniGesture == 'S') {
                countScissors++;
            }
        }

        char francoGesture = 'R';

        if (countPaper >= countRock && countPaper >= countScissors) {
            francoGesture = 'P'; 
        } else if (countScissors >= countRock && countScissors >= countPaper) {
            francoGesture = 'S'; 
        }

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
