package JavaDataStructures.HashMap;
//Crie um JavaDataStructures.HashMap que armazene o nome e a idade de 5 pessoas. Em seguida, imprima o nome e a idade de cada pessoa, ordenados pelo nome.

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NamesByOrder {

    public static void main(String[] args) {

        HashMap<String, Integer> names = new HashMap<>();

        names.put("Pedro", 60);
        names.put("Carlos", 55);
        names.put("Ana Luiza", 15);
        names.put("Felipe", 34);

        var orderList = names
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        var orderList2 = names
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        System.out.println(orderList);
        System.out.println(orderList2);
        sortByValue(names);
    }

    public static void sortByValue(HashMap<String, Integer> names) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(names.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());

        System.out.println(list);

    }
}
