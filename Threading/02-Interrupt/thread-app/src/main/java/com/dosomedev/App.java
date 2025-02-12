package com.dosomedev;

import java.util.ArrayList;
import java.util.List;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        stateExample();
        priorityExample();
        interruptionExample();
    }

    private static void stateExample() throws InterruptedException {
        System.out.println("State Example:");

        // Sprinter steve = new Sprinter("Steve", 250);
        // Sprinter chuck = new Sprinter("Chuck", 650);
        // Sprinter eddie = new Sprinter("Eddie", 150);
        Sprinter steve = new Sprinter("Steve", 0);
        Sprinter chuck = new Sprinter("Chuck", 0);
        Sprinter eddie = new Sprinter("Eddie", 0);

        Coach coach = new Coach(List.of(steve, chuck, eddie));

        coach.start();

        Thread.sleep(1000);

        steve.start();
        steve.join();
        chuck.start();
        chuck.join();
        eddie.start();
        eddie.join();

        coach.join();

        System.out.println("The race is done!");
    }

    private static void priorityExample() throws InterruptedException {
        System.out.println("Priority Example:");
        System.out.printf("Number of processors: %s%n", Runtime.getRuntime().availableProcessors());

        // Create sprinters.
        List<Sprinter> sprinters = new ArrayList<>();
        for (int i=1; i<=100; i++) {
            Sprinter sprinter = new Sprinter(String.valueOf(i), 0);
            sprinter.setPriority(i <= 10 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY);
            sprinters.add(sprinter);
        }

        // Start sprinters.
        for (Sprinter sprinter : sprinters) {
            sprinter.start();
        }

        // Print sprinter status.
        boolean unfinishedThreads = true;
        while (unfinishedThreads) {
            unfinishedThreads = false;
            for (Sprinter sprinter : sprinters) {
                if (sprinter.getState() == Thread.State.TERMINATED) {
                    System.out.print("-");
                } else {
                    System.out.print("o");
                    unfinishedThreads = true;
                }
            }
            System.out.println();

            Thread.sleep(500);
        }
    }

    private static void interruptionExample() throws InterruptedException {
        System.out.println("Interruption Example:");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                long count = 0;

                boolean interrupted = false;
                while (!interrupted) {
                    if (Thread.interrupted()) {
                        interrupted = true;
                    }

                    // try {
                    //     Thread.sleep(800);
                    // } catch (InterruptedException e) {
                    //     interrupted = true;
                    // }

                    count++;
                }
                
                System.out.printf("%s counter: %s%n", name, String.format("%,d", count));
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();

        Thread.sleep(1000);

        t1.interrupt();
        t2.interrupt();
    }
}
