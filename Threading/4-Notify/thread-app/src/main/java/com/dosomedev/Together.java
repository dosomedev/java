package com.dosomedev;

public class Together {
    private int number;
    private volatile boolean writable = true;

    public synchronized void setNumber(int number) {
        // Condition for producer to wait for consumer.
        while (!this.writable) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }

        // Perform some work.
        this.number = number;

        // Allow consumer to work.
        this.writable = false;
        notify();
    }

    public synchronized int getNumber() {
        // Condition for consumer to wait for producer.
        while (this.writable) {
            try {
                wait();
            } catch (InterruptedException ex) {}
        }

        // Perform some work.
        int numberCopy = this.number;

        // Allow producer to work.
        this.writable = true;
        notify();

        return numberCopy;
    }
}
