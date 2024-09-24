package com.dosomedev;

import java.util.concurrent.CompletableFuture;

public class ThrowErrorExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Example with one Future that throws an error:");
        
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Some Error Message");
        });

        future.exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return 0;
        });
    }
}
