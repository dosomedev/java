package com.dosomedev;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main(String[] args) {
        ReentrantLockExample example1 = new ReentrantLockExample();
        example1.run();

        ConditionExample example2 = new ConditionExample();
        example2.run();

        ReentrantReadWriteLockExample example3 = new ReentrantReadWriteLockExample();
        example3.run();

        StampedLockExample example4 = new StampedLockExample();
        example4.run();
    }
}
