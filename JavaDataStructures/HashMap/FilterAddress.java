package JavaDataStructures.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//Crie um JavaDataStructures.HashMap que armazene o nome e o endereço de 5 pessoas. Em seguida, imprima o endereço da pessoa com o nome "João", ordenado pelo número do endereço.

public class FilterAddress {

    public static void main(String[] args) {
        HashMap<String, String> pessoas = new HashMap<>();

        pessoas.put("Ana Luiza", "Rua da Paz, 100");
        pessoas.put("Maria", "Rua da Felicidade, 200");
        pessoas.put("João", "Rua da Alegria, 300");
        pessoas.put("Ana", "Rua da Esperança, 400");
        pessoas.put("Carlos", "Rua do Amor, 500");

        var target = "João";
        var filter = pessoas.entrySet()
                .stream()
                .filter(name -> name.getKey().equals(target))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        System.out.println(filter);
    }

}
