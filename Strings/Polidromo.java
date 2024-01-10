package Strings;

public class Polidromo {

    public static void main(String[] args) {

        String phase = "A man, a plan, a canal – Panama";

        String phaseClear = phase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPolidromo = isPolidromo(phaseClear);
        System.out.println(isPolidromo);
    }

    public static boolean isPolidromo(String phase) {

        StringBuilder reversePhase = new StringBuilder(phase);
        return phase.equals(reversePhase.reverse().toString());

    }

}
