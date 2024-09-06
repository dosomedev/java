package com.dosomedev;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerNonBlocking implements ProducerConsumerQueue {
    private final int capacity = 10;
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

    public void produce() {
        try {
            while (true) {
                int producedItem = produceItem();
                if (queue.offer(producedItem)) {
                    System.out.println("Produced item: " + producedItem);
                } else {
                    System.out.println("Produced item offer failed. Queue full. Waiting 1000 ms.");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException ex) {
            System.err.println("Producer was interrupted!");
        }
    }

    public void consume() {
        try {
            while (true) {
                Integer consumedItem = queue.poll();
                if (consumedItem != null) {
                    System.out.println("Consumed item: " + consumedItem);
                } else {
                    System.out.println("Consumed item poll failed. Queue empty. Waiting 1000 ms.");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException ex) {
            System.err.println("Consumer was interrupted!");
        }
    }

    private int produceItem() {
        return (int) (Math.random() * 100);
    }
}
