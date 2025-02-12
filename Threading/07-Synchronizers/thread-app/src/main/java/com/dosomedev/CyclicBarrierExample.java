package com.dosomedev;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample implements Runnable {
    @Override
    public void run() {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All workers have reached the checkpoint!");
        });

        for (int i=1; i<=3; i++) {
            final int sleepTimeMillis = 1000 * i;

            new Thread(() -> {
                try {
                    // Simulate some work.
                    System.out.println("Worker " + Thread.currentThread().getId() + " start work.");
                    Thread.sleep(sleepTimeMillis);
                    System.out.println("Worker " + Thread.currentThread().getId() + " reaching the checkpoint.");

                    // Wait for all workers to group here.
                    barrier.await();
                    System.out.println("Worker " + Thread.currentThread().getId() + " continuing work.");
                } catch (InterruptedException | BrokenBarrierException ex) {
                    System.err.println(ex.getMessage());
                }
            }).start();
        }
    }
}
