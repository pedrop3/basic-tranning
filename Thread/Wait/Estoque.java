package Thread.Wait;

import java.util.ArrayList;
import java.util.List;

class Estoque {
    private List<Produto> produtos;
    private int capacidadeMaxima;

    public Estoque(int capacidadeMaxima) {
        this.produtos = new ArrayList<>();
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public synchronized void put(Produto produto) throws InterruptedException {
        while (produtos.size() == capacidadeMaxima) {
            wait();
        }

        produtos.add(produto);
        System.out.println("Produtor produziu: " + produto.getNome());
        notifyAll();
    }

    public synchronized Produto get() throws InterruptedException {
        while (produtos.isEmpty()) {
            wait();
        }

        Produto produto = produtos.remove(0);
        System.out.println("Consumidor consumiu: " + produto.getNome());
        notifyAll();
        return produto;
    }
}