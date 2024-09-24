package com.dosomedev;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureListExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Example with a List of Futures run through another Future:");

        List<CompletableFuture<String>> futures = Arrays.asList(
            CompletableFuture.supplyAsync(() -> "Future A result!"),
            CompletableFuture.supplyAsync(() -> "Future B result!"),
            CompletableFuture.supplyAsync(() -> "Future C result!")
        );

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        combinedFuture.thenRun(() -> {
            futures.forEach(future -> {
                try {
                    System.out.println("Combined Future: " + future.get());
                } catch (ExecutionException | InterruptedException ex) {
                    System.err.println("Combined Future Error! Message: " + ex.getMessage());
                }
            });
        });
    }
}
