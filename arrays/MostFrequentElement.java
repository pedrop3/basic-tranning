package arrays;

import java.util.*;
import java.util.concurrent.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

public class MostFrequentElement {

    // Método O(n²) - Brute Force
    public static int mostFrequentBruteForce(int[] nums) {
        int maxCount = 0;
        int mostFrequent = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = nums[i];
            }
        }
        return mostFrequent;
    }

    // Método O(n) - HashMap
    public static int mostFrequentOptimized(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> frequencyMap = new ConcurrentHashMap<>();
        int mostFrequent = nums[0];
        int counter = 0;

        for (int num : nums) {
           // int count = frequencyMap.getOrDefault(num, 0) + 1;
            int count = frequencyMap.getOrDefault(num,0) + 1;
            frequencyMap.put(num,count);
            if (count> counter) {
                counter = count;
                mostFrequent = num;
            }
        }

        if (counter == 1) {
            throw new RuntimeException("No frequent element found");
        }

        return mostFrequent;
    }

    public static int mostFrequentOptimized2(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> frequencyMap = new ConcurrentHashMap<>();
        int mostFrequent = nums[0];
        int counter = 0;

        for (int num : nums) {
            int count = frequencyMap.merge(num,1,Integer::sum);

            if (count> counter) {
                counter = count;
                mostFrequent = num;
            }
        }

        if (frequencyMap.size() == nums.length) {
            throw new RuntimeException("No frequent element found");
        }

        return mostFrequent;
    }

    public static int mostFrequentOptimized3(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> frequencyMap = new ConcurrentHashMap<>(nums.length / 2);
        int mostFrequent = nums[0];
        int counter = 0;

        for (int num : nums) {
            int count = frequencyMap.merge(num,1,Integer::sum);

            if (count> counter) {
                counter = count;
                mostFrequent = num;
            }
        }

        if (frequencyMap.size() == nums.length) {
            throw new RuntimeException("No frequent element found");
        }

        return mostFrequent;
    }

    public static int mostFrequentOptimized4(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int estimatedUniqueValues = (int) (nums.length * 0.5);
        int initialCapacity = calculateInitialCapacity(estimatedUniqueValues);
        Map<Integer, Integer> frequencyMap = new ConcurrentHashMap<>(initialCapacity);

        int mostFrequent = nums[0];
        int counter = 0;

        for (int num : nums) {
           int count = frequencyMap.merge(num,1,Integer::sum);

            if (count> counter) {
                counter = count;
                mostFrequent = num;
            }
        }

        if (frequencyMap.size() == nums.length) {
            throw new RuntimeException("No frequent element found");
        }

        return mostFrequent;
    }

    public static int mostFrequentOptimized5(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int estimatedUniqueValues = (int) (nums.length * 0.5);
        float loadFactor = 0.75f;
        int initialCapacity = (int) (estimatedUniqueValues / loadFactor) + 1;
        Map<Integer, MutableInt> frequencyMap = new ConcurrentHashMap<>(initialCapacity, loadFactor);

        int mostFrequent = nums[0];
        int maxCount = 0;

        for (int num : nums) {
            MutableInt current = frequencyMap.get(num);
            if (current == null) {
                current = new MutableInt(1);
                frequencyMap.put(num, current);
            } else {
                current.value++;
            }
            if (current.value > maxCount) {
                maxCount = current.value;
                mostFrequent = num;
            }
        }

        if (frequencyMap.size() == nums.length) {
            throw new RuntimeException("No frequent element found");
        }

        return mostFrequent;
    }

    //Autoboxing
    private static class MutableInt {
        int value;

        MutableInt(int value) {
            this.value = value;
        }
    }

    public static int mostFrequentOptimized6(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        CustomFrequencyMap frequencyMap = new CustomFrequencyMap(nums.length);
        int mostFrequent = nums[0];
        int maxCount = 0;

        for (int num : nums) {
            int currentCount = frequencyMap.incrementAndGet(num);
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequent = num;
            }
        }

        if (frequencyMap.uniqueCount() == nums.length) {
            throw new RuntimeException("No frequent element found");
        }

        return mostFrequent;
    }

    // Tabela hash otimizada para int/int
    static class CustomFrequencyMap {
        private static final float LOAD_FACTOR = 0.75f;
        private int[] keys;
        private int[] counts;
        private int size;
        private int capacity;

        public CustomFrequencyMap(int maxEntries) {
            this.capacity = nextPowerOfTwo((int) (maxEntries / LOAD_FACTOR) + 1);
            this.keys = new int[capacity];
            this.counts = new int[capacity];
            Arrays.fill(keys, Integer.MIN_VALUE); // Usamos Integer.MIN_VALUE como marcador de slot vazio
        }

        private int nextPowerOfTwo(int n) {
            n--;
            n |= n >> 1;
            n |= n >> 2;
            n |= n >> 4;
            n |= n >> 8;
            n |= n >> 16;
            return n + 1;
        }

        public int incrementAndGet(int key) {
            int hash = getHash(key);
            while (keys[hash] != Integer.MIN_VALUE && keys[hash] != key) {
                hash = (hash + 1) & (capacity - 1); // Linear probing
            }

            if (keys[hash] == Integer.MIN_VALUE) {
                keys[hash] = key;
                counts[hash] = 1;
                size++;
                if (size >= capacity * LOAD_FACTOR) {
                    resize();
                }
                return 1;
            } else {
                return ++counts[hash];
            }
        }

        private void resize() {
            int newCapacity = capacity * 2;
            int[] oldKeys = keys;
            int[] oldCounts = counts;

            keys = new int[newCapacity];
            counts = new int[newCapacity];
            Arrays.fill(keys, Integer.MIN_VALUE);
            capacity = newCapacity;
            size = 0;

            for (int i = 0; i < oldKeys.length; i++) {
                if (oldKeys[i] != Integer.MIN_VALUE) {
                    int key = oldKeys[i];
                    int count = oldCounts[i];
                    int hash = getHash(key);
                    while (keys[hash] != Integer.MIN_VALUE) {
                        hash = (hash + 1) & (capacity - 1);
                    }
                    keys[hash] = key;
                    counts[hash] = count;
                    size++;
                }
            }
        }

        private int getHash(int key) {
            return (key * 0x9E3779B9) & (capacity - 1); // Mistura de bits para melhor distribuição
        }

        public int uniqueCount() {
            return size;
        }
    }

    static class ConcurrentFrequencyMap {
        private static final float LOAD_FACTOR = 0.75f;
        private static final int STRIPES = 16; // Número de segmentos (ajuste conforme necessário)

        private volatile int[] keys;
        private volatile int[] counts;
        private final ReentrantLock[] locks;
        private volatile int size;
        private volatile int capacity;

        public ConcurrentFrequencyMap(int maxEntries) {
            this.capacity = nextPowerOfTwo((int) (maxEntries / LOAD_FACTOR) + 1);
            this.keys = new int[capacity];
            this.counts = new int[capacity];
            Arrays.fill(keys, Integer.MIN_VALUE);
            this.locks = new ReentrantLock[STRIPES];
            for (int i = 0; i < STRIPES; i++) {
                locks[i] = new ReentrantLock();
            }
        }

        private int nextPowerOfTwo(int n) {
            n--;
            n |= n >> 1;
            n |= n >> 2;
            n |= n >> 4;
            n |= n >> 8;
            n |= n >> 16;
            return n + 1;
        }

        public int incrementAndGet(int key) {
            int hash = getHash(key);
            int stripe = hash % locks.length;
            locks[stripe].lock();
            try {
                while (true) {
                    int index = hash & (capacity - 1);
                    while (keys[index] != Integer.MIN_VALUE && keys[index] != key) {
                        index = (index + 1) & (capacity - 1);
                    }

                    if (keys[index] == Integer.MIN_VALUE) {
                        keys[index] = key;
                        counts[index] = 1;
                        size++;
                        if (size >= capacity * LOAD_FACTOR) {
                            resize();
                        }
                        return 1;
                    } else {
                        return ++counts[index];
                    }
                }
            } finally {
                locks[stripe].unlock();
            }
        }

        private void resize() {
            // Bloqueia todos os segmentos para evitar concorrência durante o resize
            for (ReentrantLock lock : locks) {
                lock.lock();
            }
            try {
                int newCapacity = capacity * 2;
                int[] oldKeys = keys;
                int[] oldCounts = counts;

                int[] newKeys = new int[newCapacity];
                int[] newCounts = new int[newCapacity];
                Arrays.fill(newKeys, Integer.MIN_VALUE);

                for (int i = 0; i < oldKeys.length; i++) {
                    if (oldKeys[i] != Integer.MIN_VALUE) {
                        int newHash = getHash(oldKeys[i]) & (newCapacity - 1);
                        while (newKeys[newHash] != Integer.MIN_VALUE) {
                            newHash = (newHash + 1) & (newCapacity - 1);
                        }
                        newKeys[newHash] = oldKeys[i];
                        newCounts[newHash] = oldCounts[i];
                    }
                }

                keys = newKeys;
                counts = newCounts;
                capacity = newCapacity;
            } finally {
                for (ReentrantLock lock : locks) {
                    lock.unlock();
                }
            }
        }

        private int getHash(int key) {
            return key * 0x9E3779B9; // Mistura de bits para distribuição uniforme
        }

        public int uniqueCount() {
            return size;
        }

    }

    public static int mostFrequentOptimizedWithThreads(int[] nums) throws InterruptedException, ExecutionException {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (nums.length == 1) {
            return nums[0];
        }

//        int numThreads = Runtime.getRuntime().availableProcessors();
        int numThreads = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int chunkSize = (nums.length + numThreads - 1) / numThreads;

        List<Future<Map<Integer, Integer>>> futures = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, nums.length);
            futures.add(executor.submit(() -> computeFreq(nums, start, end)));
        }

        List<Map<Integer, Integer>> localMaps = new ArrayList<>();
        for (Future<Map<Integer, Integer>> future : futures) {
            try {
                localMaps.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                executor.shutdownNow();
                throw new RuntimeException(e);
            }
        }
        executor.shutdown();

        Map<Integer, Integer> globalMap = mergeMaps(localMaps);

        if (globalMap.size() == nums.length) {
            throw new RuntimeException("No frequent element found");
        }

        int mostFrequent = -1;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : globalMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;
    }
    private static Map<Integer, Integer> computeFreq(int[] nums, int start, int end) {
        // Each thread uses its own HashMap (thread-confined, no shared access)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i < end; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        return map;
    }

    private static Map<Integer, Integer> mergeMaps(List<Map<Integer, Integer>> maps) {
        // Merge in a single-threaded context (no concurrency here)
        Map<Integer, Integer> merged = new HashMap<>();
        for (Map<Integer, Integer> map : maps) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                merged.merge(entry.getKey(), entry.getValue(), Integer::sum);
            }
        }
        return merged;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[]  arrayInt = generateRandomArray(10000,1,10000);


        long startTime0 = System.currentTimeMillis();
        System.out.println(mostFrequentBruteForce(arrayInt));
        long endTime0 = System.currentTimeMillis();
        long duration0 = endTime0 - startTime0;

        System.out.println("Tempo de execução: mostFrequentBruteForce " + duration0 + " milisegundos\n");

        long startTime1 = System.currentTimeMillis();
        System.out.println(mostFrequentOptimized(arrayInt));
        long endTime1 = System.currentTimeMillis();
        long duration1 = endTime1 - startTime1;
        System.out.println("Tempo de execução: mostFrequentOptimized " + duration1 + " milisegundos\n,");

        long startTime2 = System.currentTimeMillis();
        System.out.println(mostFrequentOptimized2(arrayInt));
        long endTime2 = System.currentTimeMillis();
        long duration2 = endTime2 - startTime2;

        System.out.println("Tempo de execução: mostFrequentOptimized2 " + duration2 + " milisegundos\n");

        long startTime3 = System.currentTimeMillis();
        System.out.println(mostFrequentOptimized3(arrayInt));
        long endTime3 = System.currentTimeMillis();
        long duration3 = endTime3 - startTime3;

        System.out.println("Tempo de execução: mostFrequentOptimized3 " + duration3 + " milisegundos\n");

        long startTime4 = System.currentTimeMillis();
        System.out.println(mostFrequentOptimized4(arrayInt));
        long endTime4 = System.currentTimeMillis();
        long duration4 = endTime4 - startTime4;

        System.out.println("Tempo de execução: mostFrequentOptimized4 " + duration4 + " milisegundos\n");


        long startTime5 = System.currentTimeMillis();
        System.out.println(mostFrequentOptimized5(arrayInt));
        long endTime5 = System.currentTimeMillis();
        long duration5 = endTime5 - startTime5;

        System.out.println("Tempo de execução: mostFrequentOptimized5 " + duration5 + " milisegundos\n");

        long startTime6 = System.currentTimeMillis();
        System.out.println(mostFrequentOptimized6(arrayInt));
        long endTime6 = System.currentTimeMillis();
        long duration6 = endTime6 - startTime6;

        System.out.println("Tempo de execução: mostFrequentOptimized6 " + duration6 + " milisegundos\n");


        long startTime8 = System.currentTimeMillis();
        System.out.println(mostFrequentOptimizedWithThreads(arrayInt));
        long endTime8 = System.currentTimeMillis();
        long duration8 = endTime8 - startTime8;

        System.out.println("Tempo de execução: mostFrequentOptimizedWithThreads " + duration8 + " milisegundos\n");
    }


    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] randomArray = new int[size];

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(max - min + 1) + min;
        }

        return randomArray;
    }
    /**
     * Calcula a capacidade inicial ideal para um {@link HashMap}, com base no número de elementos esperados e no fator de carga.
     * <p>
     * O {@link HashMap} em Java utiliza um fator de carga padrão de 0.75, o que significa que o mapa aumenta de tamanho quando está
     * 75% cheio. Este método calcula a capacidade inicial necessária para acomodar o número estimado de elementos únicos de forma
     * eficiente, minimizando redimensionamentos durante a execução.
     * </p>
     * <p>
     * A fórmula utilizada para calcular a capacidade inicial é:
     * </p>
     * <pre>
     * capacidade inicial = número de elementos esperados / fator de carga
     * </pre>
     * <p>
     * Se o número estimado de elementos únicos for superior à capacidade inicial, o {@link HashMap} redimensionará sua capacidade
     * para acomodar todos os elementos. No entanto, se a capacidade inicial for muito baixa, o mapa precisará crescer várias vezes,
     * o que pode impactar negativamente a performance.
     * </p>
     *
     * @param expectedSize o número de elementos únicos estimado que o {@link HashMap} irá armazenar.
     * @return a capacidade inicial calculada, que é um valor inteiro que representa a quantidade de buckets necessária.
     * @throws IllegalArgumentException se o número de elementos esperados for negativo ou zero.
     */
    public static int calculateInitialCapacity(int expectedSize) {
        return (int) Math.ceil(expectedSize / 0.75);
    }


}




