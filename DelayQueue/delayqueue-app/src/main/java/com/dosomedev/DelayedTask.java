package com.dosomedev;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {
    private final long delayInNanos;
    private final String message;

    public DelayedTask(long delayInMillis, String message) {
        this.delayInNanos = System.nanoTime()
            + TimeUnit.MILLISECONDS.toNanos(delayInMillis);
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = delayInNanos - System.nanoTime();
        return unit.convert(diff, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this == o) {
            return 0;
        }
        
        if (o instanceof DelayedTask) {
            DelayedTask other = (DelayedTask) o;
            return Long.compare(this.delayInNanos, other.delayInNanos);
        }

        return Long.compare(
            this.getDelay(TimeUnit.NANOSECONDS),
            o.getDelay(TimeUnit.NANOSECONDS)
        );
    }

    public String getMessage() {
        return message;
    }
}
