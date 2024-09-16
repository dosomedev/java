package com.dosomedev;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * PriorityBlockingQueue example.
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException
    {
        PriorityBlockingQueue<Task> queue =
            new PriorityBlockingQueue<>(10, new TaskComparator());

        queue.add(new Task(2, "Mid-priority task"));
        queue.add(new Task(1, "High-priority task"));
        queue.add(new Task(3, "Low-priority task"));
        
        while (!queue.isEmpty()) {
            Task task = queue.take();
            System.out.println(task);
        }
    }
}
