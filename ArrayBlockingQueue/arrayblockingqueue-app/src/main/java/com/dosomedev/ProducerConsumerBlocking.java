package com.dosomedev;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlocking implements ProducerConsumerQueue {
    private final int capacity = 10;
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

    public void produce() {
        try {
            while (true) {
                int producedItem = produceItem();
                queue.put(producedItem);
                System.out.println("Produced item: " + producedItem);
            }
        } catch (InterruptedException ex) {
            System.err.println("Producer was interrupted!");
        }
    }

    public void consume() {
        try {
            while (true) {
                int consumedItem = queue.take();
                System.out.println("Consumed item: " + consumedItem);
            }
        } catch (InterruptedException ex) {
            System.err.println("Consumer was interrupted!");
        }
    }

    private int produceItem() {
        return (int) (Math.random() * 100);
    }
}
