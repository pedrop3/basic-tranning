package arrays.Testes;

import java.util.TreeMap;

/*
 * TreeMap:
Suponha que você esteja desenvolvendo um sistema de gerenciamento de produtos, e
 você precisa armazenar informações sobre os produtos em um mapa onde a chave é o
  nome do produto e o valor é o preço do produto. Use um TreeMap para garantir que os produtos sejam ordenados por ordem alfabética.
 */
public class KeyValue {

    public static void main(String[] args) {

        treeMap();

    }

    private static void treeMap() {

        TreeMap<String, Double> productMap = new TreeMap<>();

        productMap.put("Zenphone", 100.00);
        productMap.put("LapTop", 100.00);
        productMap.put("Armario", 500.00);
        productMap.put("SmartPhone", 800.00);

        for (var entry : productMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    class Product {
        String name;
        Double price;

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }

        Product(String name, Double price) {
            this.name = name;
            this.price = price;
        }

    }

}
