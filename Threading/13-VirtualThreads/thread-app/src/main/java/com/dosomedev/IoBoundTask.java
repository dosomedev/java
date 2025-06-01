package com.dosomedev;

import java.util.concurrent.ThreadLocalRandom;

public class IoBoundTask implements Runnable {
    private final int taskId;

    public IoBoundTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            // Simulate an I/O operation, waiting between 50ms and 200ms.
            // e.g. network call, database query
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200));
        } catch (InterruptedException ex) {
            // Re-interrupt the current thread to propagate the interruption signal.
            Thread.currentThread().interrupt();
            // Output error.
            System.err.println("Task " + this.taskId + " interrupted.");
        }
    }
}
