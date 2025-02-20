package com.dosomedev;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VolatileExample implements Runnable {
    private final MathContext PRECISION = new MathContext(10000, RoundingMode.HALF_UP);
    private final int CALCULATIONTIME = 1000;
    private volatile boolean isInterrupted = false;

    @Override
    public void run() {
        // Define Euler's Number calculation.
        Callable<BigDecimal> eulersNumberCalculation = new Callable<BigDecimal>() {
            @Override
            public BigDecimal call() throws Exception {
                return calculateEulersNumber();
            }
        };

        // Execute calculation.
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<BigDecimal> eulersNumberFuture = executor.submit(eulersNumberCalculation);
        
        // Wait for a moment.
        System.out.println("Stop Watch start.");
        try {
            Thread.sleep(CALCULATIONTIME);
            this.isInterrupted = true;
        } catch (InterruptedException ex) {
            System.err.println("Stop watch was interrupted!");
        }
        System.out.println("Stop Watch stop.");

        // Get the value.
        try {
            BigDecimal eulersNumber = eulersNumberFuture.get();
            System.out.printf("Calculated Euler's Number: %s%n", eulersNumber);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Calculation of Euler's Number interrupted!");
        }

        executor.shutdown();
    }

    private BigDecimal calculateEulersNumber() {
        BigDecimal result = BigDecimal.ZERO;
        int counter = 0;
        
        while (!this.isInterrupted) {
            BigDecimal factorial = factorial(BigDecimal.valueOf(counter));
            BigDecimal inverse = BigDecimal.ONE.divide(factorial, PRECISION);
            result = result.add(inverse);
            counter++;
        }

        result = result.setScale(PRECISION.getPrecision(), PRECISION.getRoundingMode());
        System.out.println("Iteration count: " + counter);
        
        return result;
    }

    private BigDecimal factorial(BigDecimal n) {
        BigDecimal result = BigDecimal.ONE;

        for (BigDecimal i = BigDecimal.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigDecimal.ONE)) {
            result = result.multiply(i);
        }

        return result;
    }
}
