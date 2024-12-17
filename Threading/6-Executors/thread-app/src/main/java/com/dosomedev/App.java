package com.dosomedev;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Threading example.
 *
 */
public class App 
{
    final static int PRECISION = 100;
    final static int TERMS = 4000;
    final static int POOL = 2;
    final static int THREADS = 10;

    public static void main(String[] args) {
        // Print settings.
        System.out.printf("Precision: %s%n", PRECISION);
        System.out.printf("Terms:     %s%n", TERMS);
        System.out.printf("Pool:      %s%n", POOL);
        System.out.printf("Threads:   %s%n", THREADS);

        // Define executor pool.
        //ExecutorService executor = Executors.newFixedThreadPool(POOL);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(POOL);

        // Define process.
        Callable<BigDecimal> callable = new Callable<BigDecimal>() {
            @Override
            public BigDecimal call() throws Exception {
                // Define precision and rounding.
                MathContext mc = new MathContext(PRECISION, RoundingMode.HALF_UP);

                BigDecimal result = BigDecimal.ZERO;
                for (int i=0; i<=TERMS; i++) {
                    // Calculate factorial.
                    BigDecimal factorial = factorial(new BigDecimal(i));
                    // Calculate inverse.
                    BigDecimal inverse = BigDecimal.ONE.divide(factorial, mc);
                    // Add inverse to result.
                    result = result.add(inverse);
                }

                // Return with set scale.
                return result.setScale(PRECISION, RoundingMode.HALF_UP);
            }

            private BigDecimal factorial(BigDecimal n) {
                BigDecimal result = BigDecimal.ONE;
                for (BigDecimal i = BigDecimal.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigDecimal.ONE)) {
                    result = result.multiply(i);
                }
                return result;
            }
        };

        // Create task list.
        List<Future<BigDecimal>> tasks = new ArrayList<>();
        for (int i=1; i<=THREADS; i++) {
            // Submit task to executor.
            Future<BigDecimal> task = executor.submit(callable);
            // Remember task in list.
            tasks.add(task);
        }
        
        // Tell executor to shutdown after executing all tasks.
        executor.shutdown();

        // Check if executor done with all tasks.
        boolean executorTerminated = false;
        while (!executorTerminated) {
            // Check if executor terminated.
            if (executor.isTerminated()) {
                executorTerminated = true;
            }
            
            // Print stats.
            boolean shutdown = executor.isShutdown();
            boolean terminated = executor.isTerminated();
            int pending = executor.getQueue().size();
            int active = executor.getActiveCount();
            long completed = executor.getCompletedTaskCount();
            System.out.printf("pending: %s, active: %s, completed: %s, shutdown: %s, terminated: %s%n", pending, active, completed, shutdown, terminated);

            // Set stat speed.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("Sleep interrupted!");
            }
        }

        // Print one result.
        try {
            BigDecimal eulersNumber = tasks.get(0).get();
            System.out.printf("First thread result: %s%n", eulersNumber);
        } catch (InterruptedException | ExecutionException ex) {
            System.err.println("Could not grab result!");
        }
    }
}
