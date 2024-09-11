package com.dosomedev;

import java.util.concurrent.DelayQueue;

/**
 * DelayQueue example.
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException
    {
        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();

        // Add tasks with different delays.
        delayQueue.add(new DelayedTask(5400, "1st Task"));
        delayQueue.add(new DelayedTask(500, "2nd Task"));
        delayQueue.add(new DelayedTask(3200, "3rd Task"));
        delayQueue.add(new DelayedTask(10200, "4th Task"));

        // Process tasks as they become available.
        long startTimeMillis = System.currentTimeMillis();
        
        while (!delayQueue.isEmpty()) {
            System.out.print("Get task...");

            DelayedTask task = delayQueue.take();
            long stopTimeMillis = System.currentTimeMillis();

            System.out.println("done in " + (stopTimeMillis - startTimeMillis)
                + " ms! Message: " + task.getMessage());
        }
    }
}
