package com.dosomedev;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class CalculateEuler implements Callable<BigDecimal> {
    private final int iterations;

    public CalculateEuler(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public BigDecimal call() throws Exception {
        MathContext precision = new MathContext(100, RoundingMode.HALF_UP);
        BigDecimal result = BigDecimal.ZERO;

        for (int i=0; i<=iterations; i++) {
            BigDecimal factorial = factorial(new BigDecimal(i));
            BigDecimal inverse = BigDecimal.ONE.divide(factorial, precision);
            result = result.add(inverse);
        }
        
        return result;
    }

    private BigDecimal factorial(BigDecimal n) {
        if (n.equals(BigDecimal.ZERO)) {
            return BigDecimal.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }
}
