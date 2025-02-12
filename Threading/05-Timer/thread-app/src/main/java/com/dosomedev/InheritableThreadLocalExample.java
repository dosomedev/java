package com.dosomedev;

public class InheritableThreadLocalExample implements Runnable {
    private static final InheritableThreadLocal<Integer> intVal = new InheritableThreadLocal<>();

    @Override
    public void run() {
        Runnable parent = () -> {
            // Set inheritable thread local values.
            intVal.set(42);

            Runnable child = () -> {
                // Get thread name.
                String name = Thread.currentThread().getName();

                // Print child values.
                System.out.printf("Thread name: %s, InheritableThreadLocal value: %d%n", name, intVal.get());
            };

            // Get thread name.
            String name = Thread.currentThread().getName();
            
            // Print parent values.
            System.out.printf("Thread name: %s, InheritableThreadLocal value: %d%n", name, intVal.get());

            // Create child thread.
            Thread childThread = new Thread(child);
            childThread.setName("Child");
            childThread.start();
        };

        // Create parent thread.
        Thread parentThread = new Thread(parent);
        parentThread.setName("Parent");
        parentThread.start();
    }
}
