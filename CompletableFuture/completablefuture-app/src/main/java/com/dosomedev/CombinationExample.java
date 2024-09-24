package com.dosomedev;

import java.util.concurrent.CompletableFuture;

public class CombinationExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Example with two CompletableFutures that are combined:");
        
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "welld!";
        });

        CompletableFuture<String> futureCombined = future1.thenCombine(future2, (s1, s2) -> {
            return s1 + " " + s2;
        });

        futureCombined.thenAccept(System.out::println);
    }
}
