package com.dosomedev;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * EnumSet example.
 *
 */
public class App 
{
    private static final int ROUNDS = 6;
    private static final int ITERATIONS = 100000000;


    private enum Color {
        RED, GREEN, BLUE, YELLOW, ORANGE, PURPLE
    }

    private enum BenchmarkType {
        ADD, CONTAINS, REMOVE
    }

    public static void main( String[] args )
    {
        runBenchmarkType(BenchmarkType.ADD);
        runBenchmarkType(BenchmarkType.CONTAINS);
        runBenchmarkType(BenchmarkType.REMOVE);
    }

    private static void runBenchmarkType(BenchmarkType type) {
        // Create sets.
        Color[] colors = Color.values();
        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);
        HashSet<Color> hashSet = new HashSet<>(Arrays.asList(colors));

        // Control variables.
        long avgEnumSet = 0;
        long avgHashSet = 0;

        // Benchmark loop.
        for (int i=0; i<ROUNDS; i++) {
            avgEnumSet += benchmark(enumSet, i + 1, type);
            avgHashSet += benchmark(hashSet, i + 1, type);
        }

        // Calculate average millis.
        avgEnumSet /= ROUNDS;
        avgHashSet /= ROUNDS;

        // Print statistics.
        System.out.println("Average EnumSet-" + type.toString() + " millis: " + avgEnumSet + " ms");
        System.out.println("Average HashSet-" + type.toString() + " millis: " + avgHashSet + " ms");
    }

    private static long benchmark(Set<Color> set, int round, BenchmarkType type) {
        Color[] colors = Color.values();

        // Mark start measurement.
        long start = System.nanoTime();

        if (type == BenchmarkType.ADD) {
            for (int i=0; i<ITERATIONS; i++) {
                set.add(colors[i % colors.length]);
            }
        } else if (type == BenchmarkType.CONTAINS) {
            for (int i=0; i<ITERATIONS; i++) {
                set.contains(colors[i % colors.length]);
            }
        } else if (type == BenchmarkType.REMOVE) {
            for (int i=0; i<ITERATIONS; i++) {
                set.remove(colors[i % colors.length]);
            }
        }

        // Mark end measurement.
        long end = System.nanoTime();
        // Calculate elapsed time.
        long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(end - start);

        // Print out time result.
        //System.out.println("Round " + round + ": " + set.getClass().getSimpleName() + " elapsed time: " + elapsedMillis + " ms");

        return elapsedMillis;
    }
}
