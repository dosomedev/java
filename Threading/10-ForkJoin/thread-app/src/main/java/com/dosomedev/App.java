package com.dosomedev;

/**
 * Threading example.
 *
 */
public class App 
{
    public static void main(String[] args) {
        MatrixMultiplicationExample example1 = new MatrixMultiplicationExample();
        example1.run();

        MatrixMultiplicationForkJoinExample example2 = new MatrixMultiplicationForkJoinExample();
        example2.run();
    }
}
