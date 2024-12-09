package com.dosomedev;

import java.util.ArrayList;
import java.util.List;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException {
        synchronizedCounterExample();
        deadlockExample();
    }

    private static void synchronizedCounterExample() throws InterruptedException {
        // Define system load.
        final long incrementNumber = 1000000;
        final long threadNumber = 100;

        final Counter counter = new Counter();

        // Define what to do.
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i=1; i<=incrementNumber; i++) {
                    counter.incrementNumber();
                }
            }
        };

        // Start all threads.
        List<Thread> threads = new ArrayList<>();
        for (int i=1; i<=threadNumber; i++) {
            Thread t = new Thread(r);
            threads.add(t);
            t.start();
        }

        // Wait for all threads to terminate.
        for (Thread thread : threads) {
            thread.join();
        }

        // Print results.
        System.out.printf("Counter should be: %s%n",
            String.format("%,d", incrementNumber * threadNumber));
        System.out.printf("Counter is:        %s%n",
            String.format("%,d", counter.getNumber()));
    }

    private static void deadlockExample() {
        final DeadLockCounter counter = new DeadLockCounter();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    counter.incrementA();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    counter.incrementB();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
