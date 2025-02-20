package com.dosomedev;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class AtomicExample implements Runnable {
    private final MathContext PRECISION = new MathContext(20000, RoundingMode.HALF_UP);
    private final int THREADPACKETS = 20;
    private final int ITERATIONSPERPACKET = 300;
    private final AtomicInteger counter = new AtomicInteger(0);
    private final AtomicInteger counter2 = new AtomicInteger(0);
    private final LongAccumulator minDuration = new LongAccumulator(Math::min, Long.MAX_VALUE);
    private final LongAccumulator maxDuration = new LongAccumulator(Math::max, Long.MIN_VALUE);
    private final LongAdder totalCalculationDuration = new LongAdder();

    @Override
    public void run() {
        // Remember start time.
        Instant startTime = Instant.now();

        // Define Euler's Number calculation.
        Callable<BigDecimal> eulersNumberCalculation = new Callable<BigDecimal>() {
            @Override
            public BigDecimal call() throws Exception {
                return calculateEulersNumber();
            }
        };

        // Execute calculation.
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);
        List<Future<BigDecimal>> eulersNumberFutures = new ArrayList<>();
        for (int i=0; i<THREADPACKETS; i++) {
            eulersNumberFutures.add(executor.submit(eulersNumberCalculation));
        }

        // Get the values.
        try {
            BigDecimal eulersNumber = BigDecimal.ZERO;

            for (Future<BigDecimal> eulersNumberFuture : eulersNumberFutures) {
                BigDecimal eulersNumberPart = eulersNumberFuture.get();
                eulersNumber = eulersNumber.add(eulersNumberPart);
            }
            
            System.out.printf("Euler's Number: %s%n", eulersNumber);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Calculation of Euler's Number interrupted!");
        }

        executor.shutdown();

        // Remember end time.
        Instant endTime = Instant.now();
        Long totalTimeSpent = Duration.between(startTime, endTime).toMillis();

        System.out.printf("Counter 1: %s%n", counter);
        System.out.printf("Counter 2: %s%n", counter2);
        System.out.printf("Min duration: %sms%n", minDuration);
        System.out.printf("Max duration: %sms%n", maxDuration);
        System.out.printf("Total calculation duration: %sms%n", totalCalculationDuration);
        System.out.printf("Total time spent: %sms%n", totalTimeSpent);
    }

    private BigDecimal calculateEulersNumber() {
        // Remember start time.
        Instant startTime = Instant.now();
        
        // Get calculation range.
        BigDecimal result = BigDecimal.ZERO;
        int lastIteration = this.counter.addAndGet(ITERATIONSPERPACKET);
        int firstIteration = lastIteration - ITERATIONSPERPACKET;
        
        // Calculate range.
        for (int i=firstIteration; i<lastIteration; i++) {
            BigDecimal factorial = factorial(BigDecimal.valueOf(i));
            BigDecimal inverse = BigDecimal.ONE.divide(factorial, PRECISION);
            result = result.add(inverse);

            counter2.incrementAndGet();
        }
        
        // Set result to precision.
        result = result.setScale(PRECISION.getPrecision(), PRECISION.getRoundingMode());
        
        // Remember end time.
        Instant endTime = Instant.now();
        Long duration = Duration.between(startTime, endTime).toMillis();
        minDuration.accumulate(duration);
        maxDuration.accumulate(duration);
        totalCalculationDuration.add(duration);
        System.out.printf("Calculation duration from %s to %s: %sms%n", firstIteration, lastIteration, duration);

        return result;
    }

    private BigDecimal factorial(BigDecimal n) {
        // Calculate factorial of n.
        BigDecimal result = BigDecimal.ONE;
        
        for (BigDecimal i = BigDecimal.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigDecimal.ONE)) {
            result = result.multiply(i);
        }

        return result;
    }
}
