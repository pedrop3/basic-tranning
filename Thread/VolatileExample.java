package Thread;

public class VolatileExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        // create and start a new thread
        new Thread(() -> {
            while (!flag) {
                System.out.println("Thread continues");
            }
            System.out.println("Thread finished");
        }).start();

        // set the flag to true after a delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
    }
}