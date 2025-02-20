package com.dosomedev;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main(String[] args) {
        VolatileExample example1 = new VolatileExample();
        example1.run();

        AtomicExample example2 = new AtomicExample();
        example2.run();
    }
}
