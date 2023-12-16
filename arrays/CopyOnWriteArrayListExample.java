package arrays;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    public static void main(String[] args) {
        // Creating a CopyOnWriteArrayList
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        // Adding elements to the list
        copyOnWriteArrayList.add("Java");
        copyOnWriteArrayList.add("Python");
        copyOnWriteArrayList.add("C++");

        // Creating a thread to modify the list
        Thread modifierThread = new Thread(() -> {
            // Modifying the list by adding an element
            copyOnWriteArrayList.add("JavaScript");
            System.out.println("Modifier Thread: List after modification: " + copyOnWriteArrayList);
        });

        // Creating a thread to read the list
        Thread readerThread = new Thread(() -> {
            // Reading the list using an iterator
            Iterator<String> iterator = copyOnWriteArrayList.iterator();
            while (iterator.hasNext()) {
                String element = iterator.next();
                System.out.println("Reader Thread: Element: " + element);
            }
        });

        // Starting both threads
        modifierThread.start();
        readerThread.start();

        try {
            // Waiting for both threads to finish
            modifierThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Printing the final state of the list
        System.out.println("Main Thread: Final list: " + copyOnWriteArrayList);
    }
}
