package com.dosomedev;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerOneShotExample implements Runnable {
    @Override
    public void run() {
        // Timer reference for use within TimerTask.
        Timer timer = new Timer();

        // Create thread.
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Print info.
                System.out.printf("One-shot task at: %s%n", currentTime());
                
                // Cancel timer.
                timer.cancel();
            }
        };
        
        // Schedule one-shot timer execution.
        System.out.printf("Timing one-shot at: %s%n", currentTime());
        timer.schedule(task, 1000);
    }

    private String currentTime() {
        // Get time.
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = dateTime.toLocalTime();

        // Time to string.
        return time.toString();
    }
}
