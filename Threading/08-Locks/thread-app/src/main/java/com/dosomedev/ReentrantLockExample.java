package com.dosomedev;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample implements Runnable {

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock(); 
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        ReentrantLockExample counter = new ReentrantLockExample();
        int countUntil = 10000;

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < countUntil; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < countUntil; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + counter.getCount()); 
    }
}
