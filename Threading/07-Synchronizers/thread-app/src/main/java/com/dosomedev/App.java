package com.dosomedev;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main(String[] args) {
        CountDownLatchExample example1 = new CountDownLatchExample();
        example1.run();

        CyclicBarrierExample example2 = new CyclicBarrierExample();
        example2.run();

        ExchangerExample example3 = new ExchangerExample();
        example3.run();

        SemaphoreExample example4 = new SemaphoreExample();
        example4.run();

        PhaserExample example5 = new PhaserExample();
        example5.run();
    }
}
