package com.dosomedev;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.management.relation.Role;

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
        // Create sets.
        Color[] colors = Color.values();
        EnumSet<Color> enumSet = EnumSet.allOf(Color.class);
        HashSet<Color> hashSet = new HashSet<>(Arrays.asList(colors));

        // Control variables.
        long avgEnumSet = 0;
        long avgHashSet = 0;

        // Benchmark loop.
        for (int i=0; i<ROUNDS; i++) {
            avgEnumSet += benchmark(enumSet, i + 1, BenchmarkType.ADD);
            avgHashSet += benchmark(hashSet, i + 1, BenchmarkType.ADD);
        }

        // Calculate average millis.
        avgEnumSet /= ROUNDS;
        avgHashSet /= ROUNDS;

        // Print statistics.
        System.out.println("Average EnumSet Add millis: " + avgEnumSet + " ms");
        System.out.println("Average HashSet Add millis: " + avgHashSet + " ms");
        System.out.println();

        // Control variables.
        avgEnumSet = 0;
        avgHashSet = 0;

        // Benchmark loop.
        for (int i=0; i<ROUNDS; i++) {
            avgEnumSet += benchmark(enumSet, i + 1, BenchmarkType.CONTAINS);
            avgHashSet += benchmark(hashSet, i + 1, BenchmarkType.CONTAINS);
        }

        // Calculate average millis.
        avgEnumSet /= ROUNDS;
        avgHashSet /= ROUNDS;

        // Print statistics.
        System.out.println("Average EnumSet Contains millis: " + avgEnumSet + " ms");
        System.out.println("Average HashSet Contains millis: " + avgHashSet + " ms");
        System.out.println();

        // Control variables.
        avgEnumSet = 0;
        avgHashSet = 0;

        // Benchmark loop.
        for (int i=0; i<ROUNDS; i++) {
            avgEnumSet += benchmark(enumSet, i + 1, BenchmarkType.REMOVE);
            avgHashSet += benchmark(hashSet, i + 1, BenchmarkType.REMOVE);
        }

        // Calculate average millis.
        avgEnumSet /= ROUNDS;
        avgHashSet /= ROUNDS;

        // Print statistics.
        System.out.println("Average EnumSet Remove millis: " + avgEnumSet + " ms");
        System.out.println("Average HashSet Remove millis: " + avgHashSet + " ms");
        System.out.println();
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
