package com.dosomedev;

import java.util.concurrent.Exchanger;

public class ExchangerExample implements Runnable {
    @Override
    public void run() {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread producer = new Thread(() -> {
            String buffer = "PPP";
            try {
                while (true) {
                    System.out.println("Producer sends:    " + buffer);
                    buffer = exchanger.exchange(buffer);
                    System.out.println("Producer receives: " + buffer);
                }
            } catch (InterruptedException ex) {
                System.err.println("Producer interrupted!");
            }
        });

        Thread consumer = new Thread(() -> {
            String buffer = "CCC";
            try {
                while (true) {
                    System.out.println("Consumer sends:    " + buffer);
                    buffer = exchanger.exchange(buffer);
                    System.out.println("Consumer receives: " + buffer);
                }
            } catch (InterruptedException ex) {
                System.err.println("Consumer interrupted!");
            }
        });

        producer.start();
        consumer.start();

        try {
            Thread.sleep(5);
        } catch (InterruptedException ex) {}

        producer.interrupt();
        consumer.interrupt();
    }
}
