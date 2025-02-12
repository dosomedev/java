package com.dosomedev;

import java.util.concurrent.locks.StampedLock;

public class StampedLockExample implements Runnable {
    // private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final StampedLock lock = new StampedLock();
    private int value;

    public int getValue() {
        // Get stamp for optimistic read.
        long stamp = this.lock.tryOptimisticRead();
        // Read value into local field.
        int value = this.value;

        // Validate that no write locks have been issued meanwhile.
        if (!this.lock.validate(stamp)) {
            // Acquire pessimistic read lock.
            stamp = this.lock.readLock();
            try {
                // Read value into local field.
                value = this.value;
            } finally {
                this.lock.unlockRead(stamp);
            }
        }

        System.out.println("Reader " + Thread.currentThread().getName() + " read: " + value);
        return value;
    }

    public void setValue(int value) {
        long stamp = this.lock.writeLock();
        try {
            System.out.println("Writer " + Thread.currentThread().getName() + " wrote: " + value);
            this.value = value;
        } finally {
            this.lock.unlockWrite(stamp);
        }
    }

    @Override
    public void run() {
        StampedLockExample data = new StampedLockExample();

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
