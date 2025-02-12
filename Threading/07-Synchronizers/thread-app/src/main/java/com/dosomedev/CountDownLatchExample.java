package com.dosomedev;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample implements Runnable {
    private final static int THREAD_QTY = 3;

    @Override
    public void run() {
        // Define countdown latches.
        final CountDownLatch firstStartersSignal = new CountDownLatch(1);
        final CountDownLatch yellowFinishLine = new CountDownLatch(THREAD_QTY);
        final CountDownLatch secondStartersSignal = new CountDownLatch(1);
        final CountDownLatch redFinishLine = new CountDownLatch(THREAD_QTY);

        // Define runner todos.
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for first starter's signal.
                    printMessage("Wait for first starter's signal.");
                    firstStartersSignal.await();

                    // Run to yellow finish line.
                    printMessage("Run to yellow finish line.");
                    Thread.sleep((int) Math.random() * 1000);
                    printMessage("Reached yellow finish line.");
                    yellowFinishLine.countDown();



                    // Wait for second starter's signal.
                    printMessage("Wait for second starter's signal.");
                    secondStartersSignal.await();

                    // Run to red finish line.
                    printMessage("Run to red finish line.");
                    Thread.sleep((int) Math.random() * 1000);
                    printMessage("Reached red finish line.");
                    redFinishLine.countDown();
                } catch (InterruptedException ex) {
                    printMessage(ex.getMessage());
                }
            }
        };
        
        try {
            // Define thread pool.
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_QTY);
            
            // Add and run all threads.
            printMessage("Start race.");
            for (int i=0; i<THREAD_QTY; i++) {
                executor.execute(r);
            }

            // Countdown race to yellow finish line.
            Thread.sleep(1000);
            printMessage("Ready, ...");
            Thread.sleep(1000);
            printMessage("Steady, ...");
            Thread.sleep(1000);
            printMessage("Go!!!");
            firstStartersSignal.countDown();

            // Wait for runners to reach yellow finish line.
            yellowFinishLine.await();
            printMessage("All runners reached yellow finish line.");



            // Countdown race to red finish line.
            Thread.sleep(1000);
            printMessage("Ready, ...");
            Thread.sleep(1000);
            printMessage("Steady, ...");
            Thread.sleep(1000);
            printMessage("Go!!!");
            secondStartersSignal.countDown();

            // Wait for runners to reach red finish line.
            redFinishLine.await();
            printMessage("All runners reached red finish line.");
            
            // Shutdown executor.
            printMessage("Race is over.");
            executor.shutdownNow();
        } catch (InterruptedException ex) {
            printMessage(ex.getMessage());
        }
    }

    private static void printMessage(String message) {
        System.out.println(LocalDateTime.now() + ": " +
                            Thread.currentThread() + ": " + 
                            message);
    }
}
