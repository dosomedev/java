package com.dosomedev;

import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SynchronousQueue<String> queue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer: Hello");
                queue.put("Hello");
                System.out.println("Producer: World");
                queue.put("World");
            } catch (InterruptedException ex) {
                System.err.println("Producer interrupted!");
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                String message1 = queue.take();
                System.out.println("Consumer: " + message1);
                String message2 = queue.take();
                System.out.println("Consumer: " + message2);
            } catch (InterruptedException ex) {
                System.err.println("Consumer interrupted!");
            }
        });

        producer.start();
        consumer.start();
    }
}
