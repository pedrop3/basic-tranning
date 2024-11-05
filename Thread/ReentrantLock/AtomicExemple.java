package Thread.ReentrantLock;

import java.util.concurrent.atomic.AtomicInteger;



import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // método atomic para incrementar
    }

    public int getCount() {
        return count.get(); // método atomic para obter o valor
    }
}

class AtomicExample {
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();
        int totalIncrements = 1000000000; // Total de incrementos
        int numberOfThreads = Runtime.getRuntime().availableProcessors(); // Número de threads igual ao núcleos do processador
        Thread[] threads = new Thread[50];

        long startTime = System.currentTimeMillis();

        // Calcular quantos incrementos cada thread deve realizar
        int incrementsPerThread = totalIncrements / numberOfThreads;

        // Criar e iniciar as threads
        Runnable task = () -> {
            for (int i = 0; i < incrementsPerThread; i++) { // Cada thread realiza sua parte do trabalho
                counter.increment();
            }
        };

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        // Aguardar a conclusão de todas as threads
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Final count: " + counter.getCount());
        System.out.println("Time to process: " + duration + " ms");
    }
}
