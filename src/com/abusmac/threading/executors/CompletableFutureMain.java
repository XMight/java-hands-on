package com.abusmac.threading.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Integer result = CompletableFuture.supplyAsync(() -> 100).thenApply(r -> r * 2).get();

        System.out.println("Integer result from Future: " + result);
    }
}
