package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareTo {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("João"));
        pessoas.add(new Pessoa("Maria"));
        pessoas.add(new Pessoa("Ana"));

        Comparator comparator = Collections.reverseOrder();
        Collections.sort(pessoas);

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.nome);
        }

    }

    /**
     * InnerCompareTo
     */

    public  static class Pessoa implements Comparable<Pessoa> {

        String nome;
        String sobrenome;

        public Pessoa(String nome) {
            this.nome = nome;
        }

        @Override
        public int compareTo(Pessoa outraPessoa) {
            return this.nome.compareTo(outraPessoa.nome);
        }

    }
}
