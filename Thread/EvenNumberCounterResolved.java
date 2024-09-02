package Thread;

/**
 * ### Exercise: Even Number Counter with Multi-threading
 * **Description:**
 *
 * You need to implement a Java program that counts the number of even numbers in a large array of integers, using multi-threading to improve performance.
 *
 * **Requirements:**
 *
 * - **Input:** An array of integers (for example, `int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};`).
 * - **Output:** The total number of even numbers in the array.
 *
 * **Conditions:**
 * - Use at least two threads to divide the task of counting the even numbers.
 * - The threads should sum up their partial results, and the total sum must be displayed at the end.
 */
public class EvenNumberCounterResolved {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Define the number of threads to use
        int numThreads = 3; // You can change this number to use more or fewer threads

        // Arrays to hold the EvenCounter objects and Thread objects
        EvenCounter[] counters = new EvenCounter[numThreads];
        Thread[] threads = new Thread[numThreads];

        // Calculate the size of each chunk that each thread will process
        int chunkSize = array.length / numThreads;
        int remainder = array.length % numThreads; // To handle any leftover elements

        // Initialize each thread and assign it a portion of the array
        for (int i = 0; i < numThreads; i++) {
            // Calculate the start and end indices for the current thread
            int start = i * chunkSize;
            int end = (i + 1) * chunkSize;

            // Ensure the last thread includes any remaining elements
            if (i == numThreads - 1) {
                end += remainder;
            }

            // Create an EvenCounter object for the current thread
            counters[i] = new EvenCounter(array, start, end);

            // Create and start a new thread for the EvenCounter
            threads[i] = new Thread(counters[i]);
            threads[i].start();
        }

        // Variable to hold the total count of even numbers
        int totalEvenNumbers = 0;

        // Wait for all threads to complete and aggregate their results
        for (int i = 0; i < numThreads; i++) {
            // Wait for the current thread to finish
            threads[i].join();
            // Sum up the results from each thread
            totalEvenNumbers += counters[i].getEvenCount();
        }

        // Print the total number of even numbers
        System.out.println("Total even numbers: " + totalEvenNumbers);
    }
}

class EvenCounter implements Runnable {
    private int[] array;
    private int start;
    private int end;
    private int evenCount = 0;

    // Constructor to initialize the EvenCounter with the array portion to process
    public EvenCounter(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    // The run method that will be executed by the thread
    @Override
    public void run() {
        // Iterate through the assigned portion of the array
        for (int i = start; i < end; i++) {
            // Check if the current element is even
            if (array[i] % 2 == 0) {
                // Increment the count of even numbers
                evenCount++;
            }
        }
    }

    // Getter method to retrieve the count of even numbers
    public int getEvenCount() {
        return evenCount;
    }
}


