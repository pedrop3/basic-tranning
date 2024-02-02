package arrays;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample extends Thread {

    public static void main(String[] args) {
        // Creating a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("Pedro");
        copyOnWriteArrayList.add("Henrique");
        copyOnWriteArrayList.add("Santos");

        Thread modifierThread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    

            copyOnWriteArrayList.add("Martins");
        },"ModifierThread");

        Thread readerThread = new Thread(() -> {
            copyOnWriteArrayList.forEach(value -> {
                System.out.println("Reader: " + value);
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
        },"ReaderThread");

        modifierThread.start();
        readerThread.start();

        try {
            modifierThread.join();
            readerThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread: Final list: " + copyOnWriteArrayList);
    }
}
