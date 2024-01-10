package DesignPatterns;

// Interface que define o produto a ser criado
interface Produto {
    void exibirInfo();
}

// Implementação concreta do produto
class ProdutoA implements Produto {
    @Override
    public void exibirInfo() {
        System.out.println("Produto A");
    }
}

// Outra implementação concreta do produto
class ProdutoB implements Produto {
    @Override
    public void exibirInfo() {
        System.out.println("Produto B");
    }
}

// Interface da fábrica que declara o método de criação do produto
interface Fabrica {
    Produto criarProduto();
}

// Implementação concreta da fábrica para criar ProdutoA
class FabricaProdutoA implements Fabrica {
    @Override
    public Produto criarProduto() {
        return new ProdutoA();
    }
}

// Implementação concreta da fábrica para criar ProdutoB
class FabricaProdutoB implements Fabrica {
    @Override
    public Produto criarProduto() {
        return new ProdutoB();
    }
}

// Cliente que utiliza a fábrica para criar um produto
public class Factory {
    public static void main(String[] args) {
        // Utilizando a fábrica para criar o ProdutoA
        Fabrica fabricaA = new FabricaProdutoA();
        Produto produtoA = fabricaA.criarProduto();
        produtoA.exibirInfo();

        // Utilizando a fábrica para criar o ProdutoB
        Fabrica fabricaB = new FabricaProdutoB();
        Produto produtoB = fabricaB.criarProduto();
        produtoB.exibirInfo();
    }
}

