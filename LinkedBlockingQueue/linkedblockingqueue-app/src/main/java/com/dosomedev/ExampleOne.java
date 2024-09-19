package com.dosomedev;

import java.util.concurrent.LinkedBlockingQueue;

public class ExampleOne implements Runnable {
    @Override
    public void run() {
        System.out.println("Running example one:");
        
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        // Producer.
        Thread producer = new Thread(() -> {
            try {
                queue.put("Task A");
                queue.put("Task B");
                queue.put("Task C");
            } catch (InterruptedException ex) {
                System.out.println("Producer interrupted!");
            }
        });

        // Consumer.
        Thread consumer = new Thread(() -> {
            try {
                while (!queue.isEmpty()) {
                    String element = queue.take();
                    System.out.println("Consuming " + element + ".");
                }
            } catch (InterruptedException ex) {
                System.out.println("Consumer interrupted!");
            }
        });

        // Thread start.
        producer.start();
        consumer.start();
    }
}
