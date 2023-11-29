package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}

public class ExemploComparator {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Alice", 25));
        pessoas.add(new Pessoa("Bob", 30));
        pessoas.add(new Pessoa("Charlie", 20));

        // Ordenação personalizada por idade usando Comparator
        Collections.sort(pessoas, new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa pessoa1, Pessoa pessoa2) {
                return Integer.compare(pessoa1.idade, pessoa2.idade);
            }
        });

        // Exibindo a lista ordenada
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
    }
}
