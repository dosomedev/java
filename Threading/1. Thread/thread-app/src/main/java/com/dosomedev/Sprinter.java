package com.dosomedev;

public class Sprinter extends Thread {
    private String name;
    private int stepTime;
    private int fallsDown;

    public Sprinter(String name, int stepTime, int fallsDown) {
        this.name = name;
        this.stepTime = stepTime;
        this.fallsDown = fallsDown;
    }

    @Override
    public void run() {
        System.out.printf("===> %s starts running!%n", this.name);

        for (int i=1; i<=10; i++) {
            System.out.printf("%s runs %sm.%n", this.name, i);

            if (i == this.fallsDown)
                throw new RuntimeException(String.format("%s fell down!%n", this.name));

            if (i == 10)
                System.out.printf("===> %s finished!%n", this.name);

            try {
                Thread.sleep(this.stepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
