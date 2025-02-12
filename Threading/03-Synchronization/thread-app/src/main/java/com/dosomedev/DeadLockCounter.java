package com.dosomedev;

public class DeadLockCounter {
    private long counterA = 0;
    private long counterB = 0;
    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public void incrementA() {
        synchronized(lockA) {
            synchronized(lockB) {
                this.counterA++;
                System.out.println("First lock: lockA, second lock: lockB - counterA: " +
                    this.counterA);
            }
        }
    }

    public void incrementB() {
        synchronized(lockB) {
            synchronized(lockA) {
                this.counterB++;
                System.out.println("First lock: lockB, second lock: lockA - counterB: " +
                    this.counterB);
            }
        }
    }
}
