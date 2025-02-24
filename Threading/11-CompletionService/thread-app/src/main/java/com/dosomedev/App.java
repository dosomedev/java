package com.dosomedev;

import java.math.BigDecimal;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Create service.
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<BigDecimal> completion = new ExecutorCompletionService<>(executor);

        // Create all tasks.
        Future<BigDecimal> futureB = completion.submit(new CalculateEuler(170));
        Future<BigDecimal> futureC = completion.submit(new CalculateEuler(1700));
        Future<BigDecimal> futureA = completion.submit(new CalculateEuler(17));
        
        // Tell executor to shutdown after executing all tasks.
        executor.shutdown();
        
        try {
            // Get all results.
            for (int i=1; i<=3; i++) {
                Future<BigDecimal> result = completion.take();
                System.out.println(result.get());
                System.out.println();
            }
        } catch (InterruptedException | ExecutionException ex) {
            System.err.println("Error getting Future result!");
        }
    }
}
