package Thread.Wait;

public class Main {

    public static void main(String[] args) {

        Estoque estoque = new Estoque(5);
      
        Produtor produtor1 = new Produtor(estoque, 1);
        Produtor produtor2 = new Produtor(estoque, 2);

        Consumidor consumidor1 = new Consumidor(estoque, 1);
        Consumidor consumidor2 = new Consumidor(estoque, 2);

        Thread threadProdutor1 = new Thread(produtor1);
        Thread threadProdutor2 = new Thread(produtor2);

        Thread threadConsumidor1 = new Thread(consumidor1);
        Thread threadConsumidor2 = new Thread(consumidor2);

        threadProdutor1.start();
        threadProdutor2.start();

        threadConsumidor1.start();
        threadConsumidor2.start();

    }

}
