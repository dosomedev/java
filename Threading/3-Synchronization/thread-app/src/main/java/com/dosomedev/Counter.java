package com.dosomedev;

public class Counter {
    private long number;

    public long getNumber() {
        return this.number;
    }

    public void incrementNumber() {
    //public synchronized void incrementNumber() {
        this.number++;
    }
}
