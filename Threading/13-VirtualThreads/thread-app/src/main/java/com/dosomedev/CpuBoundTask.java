package com.dosomedev;

public class CpuBoundTask implements Runnable {
    private final int number;

    public CpuBoundTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        boolean isPrime = this.checkPrime(number);
    }

    private boolean checkPrime(long n) {
        if (n <= 1) return false;
        // 2 and 3 are primes.
        if (n <= 3) return true;
        // Divisible by 2 or 3.
        if (n % 2 == 0 || n % 3 == 0) return false;
        // Check from 5 onwards with a step of 6.
        for (long i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
