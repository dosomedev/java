package com.dosomedev;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExampleFive implements Runnable {
    @Override
    public void run() {
        System.out.println("Example Five (simple task, non-blocking completion):");
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            try {
                Thread.sleep(2000);
                return 42;
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        };

        Future<Integer> future = executor.submit(task);

        while (!future.isDone()) {
            System.out.println("Waiting for task to complete...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Thread sleep interrupted! Message: " + ex.getMessage());
            }
        }

        try {
            Integer result = future.get();
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException ex) {
            System.err.println("Error occured! Message: " + ex.getMessage());
        }

        executor.shutdown();
        System.out.println();
    }
}
