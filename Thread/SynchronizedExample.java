package Thread;

public class SynchronizedExample {
    private static int counter = 0;

    public static void main(String[] args) {
        // create and start multiple threads
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized (SynchronizedExample.class) {
                    // increment the counter
                    counter++;
                    System.out.println("Counter value: " + counter);
                }
            }).start();
        }
    }
}