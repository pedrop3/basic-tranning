package Thread.FinancialSystem.Manual;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Transaction {
    private final double amount;
    private final String type;

    public Transaction(double amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" + "amount=" + amount + ", type='" + type + '\'' + '}';
    }
}

class TransactionQueue {
    private final Queue<Transaction> queue = new LinkedList<>();
    private final int limit;

    public TransactionQueue(int limit) {
        this.limit = limit;
    }

    public synchronized void addTransaction(Transaction transaction) throws InterruptedException {
        while (queue.size() == limit) {
            System.out.println("Queue is full. Producer waiting for space...");
            wait();
        }
        queue.add(transaction);
        System.out.println("Produced: " + transaction);
        notify();  // Notifies the consumer to process a transaction
    }

    public synchronized Transaction consumeTransaction() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Queue is empty. Consumer waiting for a new transaction...");
            wait();
        }
        Transaction transaction = queue.poll();
        System.out.println("Consumed: " + transaction);
        notify();  // Notifies the producer to add more transactions
        return transaction;
    }
}

class Consumer implements Runnable {
    private final TransactionQueue queue;
    private long totalProcessingTime = 0;
    private int transactionCount = 0;

    public Consumer(TransactionQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Transaction transaction = queue.consumeTransaction();
                // Processing the transaction (simulation)
                System.out.println("Processing transaction: " + transaction);
                Thread.sleep(1500);  // Simulates time to process a transaction

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Producer implements Runnable {
    private final TransactionQueue queue;

    public Producer(TransactionQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int count = 1;
            while (true) {
                Transaction transaction = new Transaction(count * 100.0, "Payment");
                queue.addTransaction(transaction);
                count++;
                Thread.sleep(1000);  // Simulates time to produce a new transaction
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class FinancialSystem {
    public static void main(String[] args) {
        int queueLimit = 5;           // Limite da fila de transações
        int numberOfProducers = 5;    // Número de produtores desejado
        int numberOfConsumers = 15;    // Número de consumidores desejado

        TransactionQueue queue = new TransactionQueue(queueLimit);

        List<Thread> producerThreads = new ArrayList<>();
        List<Thread> consumerThreads = new ArrayList<>();

        // Cria e inicia as threads dos produtores
        for (int i = 0; i < numberOfProducers; i++) {
            Producer producer = new Producer(queue);
            Thread producerThread = new Thread(producer, "Producer-" + (i + 1));
            producerThreads.add(producerThread);
            producerThread.start();
        }

        // Cria e inicia as threads dos consumidores
        for (int i = 0; i < numberOfConsumers; i++) {
            Consumer consumer = new Consumer(queue);
            Thread consumerThread = new Thread(consumer, "Consumer-" + (i + 1));
            consumerThreads.add(consumerThread);
            consumerThread.start();
        }
    }
}
