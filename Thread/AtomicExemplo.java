package Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExemplo {
    private static AtomicInteger counterAtomic = new AtomicInteger(0);
    private static int counter = 0;

    public static void main(String[] args) {

        // atomicMethod();
        System.out.println("------------------");
        onlyIncrementMethod();
    }

    private static void atomicMethod() {
        // create and start multiple threads
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // increment the counter
                int value = counterAtomic.incrementAndGet();
                System.out.println("Counter value: " + value);
            }).start();
        }
    }

    private static void onlyIncrementMethod() {
        // create and start multiple threads
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                // increment the counter
                int value = counter++;
                System.out.println("Counter value Only int: " + value);
            }).start();
        }
    }

}
