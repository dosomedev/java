package com.dosomedev;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombinationAsyncExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Example with two Futures with combined results:");

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return 10;
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                return 20;
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        CompletableFuture<Integer> futureResult = future1.thenCombineAsync(future2, (x, y) -> x + y);

        System.out.println("This message is diplayed right after starting to combine the Futures.");
        try {
            Integer result = futureResult.get();
            System.out.println("Result: " + result); // Output: 30
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println("Cobined Future Error! Message: " + ex.getMessage());
        }
        System.out.println("This message is diplayed after having waited for the combining Futures.");
    }
}
