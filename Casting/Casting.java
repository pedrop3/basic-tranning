package Casting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Casting {

    public static void main(String[] args) {

        // Casting 1
        // This will not result in a compilation error, as OptimizedDiskCache is a
        // subtype of Cache.
        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
        Cache cache = (Cache) optimizedDiskCache;

        // // Casting 2 - Error
        // This casting will result in a ClassCastException. This is because MemoryCache
        // is a subclass of Cache, but it is not an instance of DiskCache. Therefore,
        // trying to cast a MemoryCache object to a DiskCache object is an invalid
        // operation.
        try {

            MemoryCache memoryCache = new MemoryCache();
            Cache cache2 = (Cache) memoryCache;
            DiskCache diskCache = (DiskCache) cache2;

        } catch (Exception e) {
            System.out.println("Error Casting 2 \n" + e);
        }

        // // Casting 3 - Error
        // The ClassCastException you're encountering is due to the fact that you're
        // trying to cast a DiskCache object to an OptimizedDiskCache object. While
        // DiskCache is a subclass of OptimizedDiskCache, this doesn't mean that every
        // DiskCache object is also an OptimizedDiskCache
        try {
            DiskCache diskCache2 = new DiskCache();
            OptimizedDiskCache optimizedDiskCache2 = (OptimizedDiskCache) diskCache2;

        } catch (Exception e) {
            System.out.println("Error Casting 3 \n" + e);

        }

        // // Casting 4
        try {
            OptimizedDiskCache optimizedDiskCache3 = new OptimizedDiskCache();
            DiskCache diskCache3 = (DiskCache) optimizedDiskCache;
        } catch (Exception e) {

            System.out.println("Error Casting 4 " + e);
        }

        // // Casting 5 - Error
        try {
            Cache cache3 = new Cache();
            MemoryCache memoryCache3 = (MemoryCache) cache3;
        } catch (Exception e) {
            System.out.println("Error Casting 5 \n" + e);
        }

        // // Casting 6
        try {
            OptimizedDiskCache optimizedDiskCache4 = new OptimizedDiskCache();
            Cache cache4 = (Cache) optimizedDiskCache4;
            DiskCache diskCache4 = (DiskCache) cache4;
        } catch (Exception e) {
            System.out.println("Error Casting 6");

        }

    }

}

class Cache {
}

class DiskCache extends Cache {
}

class MemoryCache extends Cache {
}

class OptimizedDiskCache extends DiskCache {
}