package com.dosomedev;

import java.util.List;
import java.util.stream.Collectors;

public class Coach extends Thread {
    private List<Sprinter> sprinters;

    public Coach(List<Sprinter> sprinters) {
        this.sprinters = sprinters;
    }
    
    @Override
    public void run() {
        System.out.println("===> Coach starts watching.");
        
        boolean runningSprintersExist = true;
        while (runningSprintersExist) {
            // Check if all sprinters are done.
            runningSprintersExist = this.sprinters
                .stream()
                .anyMatch(sprinter -> sprinter.getState() != Thread.State.TERMINATED);

            // Print status.
            String sprinterStates = this.sprinters
                .stream()
                .map(sprinter -> sprinter.getSprinterName() + "/" +
                                sprinter.getState().toString() + "/" +
                                sprinter.isAlive())
                .collect(Collectors.joining(", "));
            System.out.printf("Coach note: %s%n", sprinterStates);

            // Limit coach checking speed.
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("===> Coach stops watching.");
    }
}
