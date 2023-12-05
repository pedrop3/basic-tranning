package arrays;

import java.util.LinkedList;

/**
 * LinkedList
 */
public class LinkedListExemplo {

    public static void main(String[] args) {
        

        LinkedList toList  = new LinkedList();
        toList.add("Nota");
        toList.add("Validar");

        toList.add(2,"Prova");
        toList.remove("Validar");

        System.out.println(toList);
    }
}