package Thread.FinancialSystem.Executor;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private final BlockingQueue<Transaction> queue;

    public TransactionQueue(int limit) {
        this.queue = new ArrayBlockingQueue<>(limit);  // Using a blocking queue with a specified limit
    }

    public void addTransaction(Transaction transaction) throws InterruptedException {
//         queue.put(transaction);  // This will block if the queue is full
//         System.out.println("Produced: " + transaction);
        if (!queue.offer(transaction)) {
            System.out.println("Queue is full. Producer skipping transaction: " + transaction);
        } else {
            System.out.println("Produced: " + transaction);
        }
    }

    public Transaction consumeTransaction() throws InterruptedException {
        Transaction transaction = queue.take();  // This will block if the queue is empty
        System.out.println("Consumed: " + transaction);
        return transaction;
    }
}

class Consumer implements Runnable {
    private final TransactionQueue queue;

    public Consumer(TransactionQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                long startTime = System.currentTimeMillis();  // Start processing time
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
    private final Random random = new Random();

    public Producer(TransactionQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int count = 1;
            while (true) {
                double amount = 100.0 + (random.nextDouble() * 900.0);
                amount = Math.round(amount * 100.0) / 100.0;
                Transaction transaction = new Transaction(amount, "Payment");
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
        int numberOfProducers = 15;    // Número de produtores desejado
        int numberOfConsumers = 10;    // Número de consumidores desejado

        TransactionQueue queue = new TransactionQueue(queueLimit);

        // Create a fixed thread pool for consumers
        ExecutorService consumerExecutor = Executors.newFixedThreadPool(numberOfConsumers);

        // Start consumer threads using the thread pool
        for (int i = 0; i < numberOfConsumers; i++) {
            consumerExecutor.execute(new Consumer(queue));
        }

        // Create a fixed thread pool for producers
        ExecutorService producerExecutor = Executors.newFixedThreadPool(numberOfProducers);

        // Start producer threads using the thread pool
        for (int i = 0; i < numberOfProducers; i++) {
            producerExecutor.execute(new Producer(queue));
        }

    }
}
