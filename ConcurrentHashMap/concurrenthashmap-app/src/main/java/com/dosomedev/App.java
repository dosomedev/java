package com.dosomedev;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ConcurrentHashMap example.
 *
 */
public class App
{
    private static final int ROUNDS = 6;
    private static final int THREAD_COUNT = 16;
    private static final int ITERATIONS = 1000000;

    public static void main(String[] args) throws InterruptedException
    {
        // Control variables.
        long avgHashtableMapMillis = 0;
        long avgSynchronizedHashMapMillis = 0;
        long avgConcurrentHashMapMillis = 0;
        
        // Benchmark loop.
        for (int i=0; i<ROUNDS; i++) {
            // Define maps.
            Map<String, Integer> hashtableMap = new Hashtable<>();
            Map<String, Integer> synchronizedHashMap = Collections.synchronizedMap(new HashMap<>());
            Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
            
            // Perform benchmarks.
            avgHashtableMapMillis += benchmark(hashtableMap, i + 1);
            avgSynchronizedHashMapMillis += benchmark(synchronizedHashMap, i + 1);
            avgConcurrentHashMapMillis += benchmark(concurrentHashMap, i + 1);

            System.out.println();
        }

        // Calculate average millis.
        avgHashtableMapMillis /= ROUNDS;
        avgSynchronizedHashMapMillis /= ROUNDS;
        avgConcurrentHashMapMillis /= ROUNDS;

        // Print statistics.
        System.out.println("Average Hashtable millis:            " + avgHashtableMapMillis + " ms");
        System.out.println("Average synchronized HashMap millis: " + avgSynchronizedHashMapMillis + " ms");
        System.out.println("Average ConcurrentHashMap millis:    " + avgConcurrentHashMapMillis + " ms");
    }

    private static long benchmark(Map<String, Integer> map, int round) throws InterruptedException {
        // Define threads.
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        // Mark start measurement.
        long start = System.nanoTime();

        // Run through all threads.
        for (int i=0; i<THREAD_COUNT; i++) {
            // Create thread.
            executor.submit(() -> {
                // Fill map with dummy data.
                for (int j=0; j<ITERATIONS; j++) {
                    String key = "thread " + j;
                    map.put(key, j);
                    map.get(key);
                }
            });
        }

        // Wait for submitted tasks to complete.
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Mark end measurement.
        long end = System.nanoTime();
        // Calculate elapsed time.
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(end - start);

        // Print out time result.
        System.out.println("Round " + round + ": " + map.getClass().getSimpleName() + " elapsed time: " + elapsedMillis + " ms");

        return elapsedMillis;
    }
}
