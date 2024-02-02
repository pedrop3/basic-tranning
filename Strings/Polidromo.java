package Strings;

public class Polidromo {

    public static void main(String[] args) {

        String phase = "A man, a plan, a canal – Panama";

        String clearPhase = phase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(isPolidromo(clearPhase)); 

       
    }

    public static boolean isPolidromo(String phase) {
        StringBuilder stringBuilder = new StringBuilder(phase);
        return stringBuilder.reverse().toString().equals(phase);
       
    }

}
