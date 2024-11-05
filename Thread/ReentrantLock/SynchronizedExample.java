package Thread.ReentrantLock;

class SynchronizedCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();

        long startTime = System.currentTimeMillis();

        // Multiple threads incrementing the counter
        Runnable task = () -> {
            for (int i = 0; i < 1000000000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Final count: " + counter.getCount());
        System.out.println("Time to process: " + duration + " ms");

    }
}
