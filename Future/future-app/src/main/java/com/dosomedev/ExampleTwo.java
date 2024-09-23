package com.dosomedev;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ExampleTwo implements Runnable {
    @Override
    public void run() {
        System.out.println("Example Two (task setting atomic value, wait for completion):");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        AtomicInteger resultHolder = new AtomicInteger();

        Runnable task = () -> {
            try {
                Thread.sleep(2000);
                resultHolder.set(42);
            } catch (InterruptedException ex) {
                System.err.println("Settting result holder interrupted! Message: "
                    + ex.getMessage());
            }
        };

        Future<?> future = executor.submit(task);

        try {
            future.get();
            System.out.println("Result: " + resultHolder.get());
        } catch (InterruptedException | ExecutionException ex) {
            System.err.println("Error occured! Message: " + ex.getMessage());
        }

        executor.shutdown();
        System.out.println();
    }
}
