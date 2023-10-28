package HashMap;
//Crie um HashMap que armazene o nome e a idade de 5 pessoas. Em seguida, imprima o nome e a idade de cada pessoa, ordenados pelo nome.

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NamesByOrder {

    public static void main(String[] args) {

        HashMap<String, Integer> names = new HashMap<>();

        names.put("Pedro", 15);
        names.put("Carlos", 55);
        names.put("Ana Luiza", 22);
        names.put("Felipe", 34);

        Set<Map.Entry<String, Integer>> orderNames = names.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toSet());

        System.out.println(orderNames);
    }
}
