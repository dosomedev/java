package com.dosomedev;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample implements Runnable {
    @Override
    public void run() {
        // We expect 3 threads to arrive at this phase barrier.
        Phaser phaser = new Phaser(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i=0; i<3; i++) {
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                
                // Do some work.
                try {
                    int workDuration = (int) (Math.random() * 1000);
                    print(threadName, "start work for " + workDuration + "ms");
                    Thread.sleep(workDuration);
                    print(threadName, "stop work of " + workDuration + "ms");
                } catch (InterruptedException ex) {
                    System.err.println("Thread sleep interrupted!");
                }
                waitAndPrint(threadName, "depart from phase", phaser);

                // Do some work.
                try {
                    int workDuration = (int) (Math.random() * 1000);
                    print(threadName, "start work for " + workDuration + "ms");
                    Thread.sleep(workDuration);
                    print(threadName, "stop work of " + workDuration + "ms");
                } catch (InterruptedException ex) {
                    System.err.println("Thread sleep interrupted!");
                }
                waitAndPrint(threadName, "depart from phase", phaser);
            });
        }

        executor.shutdown();
    }

    private void print(String threadName, String message) {
        System.out.printf("%s: %s %s.%n", LocalTime.now(), message, threadName);
    }

    private void waitAndPrint(String threadName, String message, Phaser phaser) {
        int phaseNumber = phaser.arriveAndAwaitAdvance();
        System.out.printf("%s: %s %s %s.%n", LocalTime.now(), threadName, message, phaseNumber);
    }
}
