package com.dosomedev;

public class Sprinter extends Thread {
    private String name;
    private int stepTime;

    public Sprinter(String name, int stepTime) {
        this.name = name;
        this.stepTime = stepTime;
    }

    public String getSprinterName() {
        return this.name;
    }

    @Override
    public void run() {
        for (int i=1; i<=10; i++) {
            if (this.stepTime > 0) {
                try {
                    Thread.sleep(this.stepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                calculatePi(10000000);
            }
        }
    }

    private double calculatePi(int numIterations) {
        double pi = 0.0;
        for (int i = 0; i < numIterations; i++) {
            double term = Math.pow(-1, i) / (2 * i + 1);
            pi += term;
        }
        return 4 * pi;
    }
}
