package arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequencia {

    public static Integer getMostPopularProductId(List<Customer> customers) {
        Map<Integer, Integer> productFrequency = new HashMap<>();


        for (Customer customer : customers) {
            for (Integer productId : customer.getSubscriptions()) {
                productFrequency.put(productId, productFrequency.getOrDefault(productId, 0) + 1);
            }
        }

        return productFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())  // Find the max by value (subscription count)
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer(1, List.of(11, 13, 15, 16, 17)),
                new Customer(2, List.of(12, 14, 17)),
                new Customer(3, List.of(13, 11, 16)),
                new Customer(4, List.of(11, 13, 17)),
                new Customer(5, List.of(12, 23, 13))
        );

        System.out.println("Most Popular Product ID: " + getMostPopularProductId(customers));
    }
}

class Customer {
    private final Integer customerId;
    private final List<Integer> subscriptions;

    public Customer(Integer customerId, List<Integer> subscriptions) {
        this.customerId = customerId;
        this.subscriptions = subscriptions;
    }

    public Integer getCustomerId() { return customerId; }
    public List<Integer> getSubscriptions() { return subscriptions; }
}