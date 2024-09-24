package com.dosomedev;

/**
 * CompletableFuture example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CombinationExample combinationExample = new CombinationExample();
        combinationExample.run();
        System.out.println();

        CombinationAsyncExample combinationAsyncExample = new CombinationAsyncExample();
        combinationAsyncExample.run();
        System.out.println();

        ThrowErrorExample throwErrorExample = new ThrowErrorExample();
        throwErrorExample.run();
        System.out.println();

        FutureListExample futureListExample = new FutureListExample();
        futureListExample.run();
        System.out.println();
    }
}
