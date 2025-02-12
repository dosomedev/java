package com.dosomedev;

public class Producer extends Thread {
    private final Together together;

    public Producer(Together together) {
        this.together = together;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            //synchronized (this.together) {
                together.setNumber(i);
                System.out.printf("Produced %s%n", i);
            //}
        }
    }
}
