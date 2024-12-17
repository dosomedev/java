package com.dosomedev;

public class ThreadLocalExample implements Runnable {
    private static volatile ThreadLocal<String> userID = new ThreadLocal<>();

    @Override
    public void run() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // Get thread name.
                String name = Thread.currentThread().getName();

                // Set ThreadLocal value.
                switch (name) {
                    case "A":
                        userID.set("alpha");
                        break;
                    case "B":
                        userID.set("beta");
                        break;
                    default:
                        userID.set("nullus");
                        break;
                }

                // Print values.
                System.out.printf("Thread name: %s, ThreadLocal value: %s%n", name, userID.get());
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        
        t1.setName("A");
        t2.setName("B");

        t1.start();
        t2.start();
        t3.start();
    }
}
