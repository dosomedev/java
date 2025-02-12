package com.dosomedev;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionExample implements Runnable {
    private final Lock lock = new ReentrantLock();
    private final Condition isProduced = lock.newCondition();
    private final Condition isConsumed = lock.newCondition();

    private final int bufferCapacity = 10;
    private final int itemQuantity = 100;
    private int capacityDigits = 0;
    private int itemDigits = 0;
    private int[] buffer = new int[bufferCapacity];
    private int bufferSize = 0;
    private int in = 0;
    private int out = 0;

    public ConditionExample() {
        this.capacityDigits = (int) Math.log10(this.bufferCapacity) + 1;
        this.itemDigits = (int) Math.log10(this.itemQuantity) + 1;
    }

    public void produce(int item) throws InterruptedException {
        this.lock.lock();
        try {
            while (this.bufferSize == this.bufferCapacity) { // Buffer is full.
                this.isConsumed.await();
            }
            this.buffer[this.in] = item;
            this.in = (this.in + 1) % this.bufferCapacity;
            this.bufferSize++;
            this.printStatus("Produce", item);
            this.isProduced.signal(); // Notify consumers.
        } finally {
            this.lock.unlock();
        }
    }

    public int consume() throws InterruptedException {
        this.lock.lock();
        try {
            while (this.bufferSize == 0) { // Buffer is emtpy.
                this.isProduced.await();
            }
            int item = this.buffer[this.out];
            this.out = (this.out + 1) % this.bufferCapacity;
            this.bufferSize--;
            this.printStatus("Consume", item);
            this.isConsumed.signal(); // Notify producers.
            return item;
        } finally {
            this.lock.unlock();
        }
    }

    @Override
    public void run() {
        ConditionExample pc = new ConditionExample();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= this.itemQuantity; i++) {
                try {
                    pc.produce(i);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= this.itemQuantity; i++) {
                try {
                    pc.consume();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void printStatus(String name, int item) {
        String itemString = String.format("%" + this.itemDigits + "s", item);
        String bufferSizeString = String.format("%" + this.capacityDigits + "s", this.bufferSize);
        System.out.printf("%s %s, Buffer %s/%s%n", name, itemString, bufferSizeString, this.bufferCapacity);
    }
}
