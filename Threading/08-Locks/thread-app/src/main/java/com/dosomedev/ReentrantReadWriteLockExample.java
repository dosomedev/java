package com.dosomedev;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockExample implements Runnable {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int value;

    public int getValue() {
        this.lock.readLock().lock();
        try {
            System.out.println("Reader " + Thread.currentThread().getName() + " read: " + this.value);
            return this.value;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    public void setValue(int value) {
        this.lock.writeLock().lock();
        try {
            System.out.println("Writer " + Thread.currentThread().getName() + " wrote: " + value);
            this.value = value;
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    @Override
    public void run() {
        ReentrantReadWriteLockExample data = new ReentrantReadWriteLockExample();

        // Create all reader threads.
        Thread[] readers = new Thread[10];
        for (int i=0; i<readers.length; i++) {
            // Add new reader thread.
            readers[i] = new Thread(() -> {
                for (int j=0; j<100; j++) {
                    data.getValue();
                }
            });
        }

        // Create all writer threads.
        Thread[] writers = new Thread[5];
        for (int i=0; i<writers.length; i++) {
            // Add new writer thread.
            writers[i] = new Thread(() -> {
                for (int j=1; j<=10; j++) {
                    data.setValue(j);
                }
            });
        }

        // Start threads.
        for (Thread reader : readers) {
            reader.start();
        }
        for (Thread writer : writers) {
            writer.start();
        }

        // Wait for all threads to finish.
        for (Thread reader : readers) {
            try {
                reader.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        for (Thread writer : writers) {
            try {
                writer.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
