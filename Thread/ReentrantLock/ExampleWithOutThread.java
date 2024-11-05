package Thread.ReentrantLock;

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class ExampleWithOutThread {
    public static void main(String[] args) {
        Counter counter = new Counter();

        long startTime = System.currentTimeMillis();

        // Multiple threads incrementing the counter
        for (int i = 0; i < 1000000000; i++) {
            counter.increment();

        };

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Final count: " + counter.getCount());
        System.out.println("Time to process: " + duration + " ms");

    }
}
