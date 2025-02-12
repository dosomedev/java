package com.dosomedev;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerIntervalExample implements Runnable {
    @Override
    public void run() {
        // Timer reference for use within TimerTask.
        Timer timer = new Timer();
        
        // Create thread.
        TimerTask task = new TimerTask() {
            int counter = 1;

            @Override
            public void run() {
                // Print info.
                System.out.printf("Interval task at: %s%n", currentTime());
                
                if (counter >= 5) {
                    // Cancel interval.
                    timer.cancel();
                } else {
                    counter++;
                }
            }
        };
        
        // Schedule interval timer execution.
        System.out.printf("Timing interval at: %s%n", currentTime());
        timer.schedule(task, 0, 2000);
    }

    private String currentTime() {
        // Get time.
        LocalDateTime dateTime = LocalDateTime.now();
        LocalTime time = dateTime.toLocalTime();

        // Time to string.
        return time.toString();
    }
}
