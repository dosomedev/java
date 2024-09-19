package com.dosomedev;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ExampleTwo implements Runnable {
    private static final int NUM_ELEMENTS = 1000;
    private static final int NUM_PRODUCERS = 4000;
    private static final int NUM_CONSUMERS = 4000;

    @Override
    public void run() {
        System.out.println("Running example two:");

        testQueue(new LinkedBlockingQueue<>());
        testQueue(new ArrayBlockingQueue<>(NUM_ELEMENTS));
        testQueue(new PriorityBlockingQueue<>());
    }

    private void testQueue(BlockingQueue<Integer> queue) {
        long startTime = System.nanoTime();

        // Producers.
        Thread[] producers = new Thread[NUM_PRODUCERS];
        for (int i = 0; i < NUM_PRODUCERS; i++) {
            producers[i] = new Thread(() -> {
                for (int j = 0; j < NUM_ELEMENTS; j++) {
                    try {
                        queue.put(j);
                    } catch (InterruptedException ex) {
                        System.out.println("Producer interrupted. Message: "
                            + ex.getMessage());
                    }
                }
            });
        }

        // Consumers.
        Thread[] consumers = new Thread[NUM_CONSUMERS];
        for (int i = 0; i < NUM_CONSUMERS; i++) {
            consumers[i] = new Thread(() -> {
                for (int j = 0; j < NUM_ELEMENTS; j++) {
                    try {
                        queue.take();
                    } catch (InterruptedException ex) {
                        System.out.println("Consumer interrupted. Message: "
                            + ex.getMessage());
                    }
                }
            });
        }

        // Start threads.
        for (Thread producer : producers) {
            producer.start();
        }
        for (Thread consumer : consumers) {
            consumer.start();
        }

        // Wait for threads to finish.
        try {
            for (Thread producer : producers) {
                producer.join();
            }
            for (Thread consumer : consumers) {
                consumer.join();
            }
        } catch (InterruptedException ex) {
            System.err.println("Join interrupted! Message: " + ex.getMessage());
        }

        // Statistics.
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(queue.getClass().getSimpleName()
            + " took " + duration / 1000000 + " ms");
    }
}
