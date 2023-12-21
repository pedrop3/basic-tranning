package HashMap;

import java.util.LinkedList;

public class SimpleHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    public SimpleHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public SimpleHashMap(int capacity) {
        this.buckets = new LinkedList[capacity];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        // Check if key already exists, update the value
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // Key not found, add a new entry
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.key.equals(key));
            size--;
        }
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        // Simple hash function (for illustration purposes)
        return Math.abs(key.hashCode() % buckets.length);
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SimpleHashMap<String, Integer> hashMap = new SimpleHashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        System.out.println("Size: " + hashMap.size());
        System.out.println("Value for key 'two': " + hashMap.get("two"));

        hashMap.remove("two");

        System.out.println("Size after removal: " + hashMap.size());
        System.out.println("Value for key 'two' after removal: " + hashMap.get("two"));
    }
}
