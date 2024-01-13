package com.abusmac.threading.executors;

import java.util.concurrent.*;

public class FutureMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> futureResult = executorService.submit(new IntReturningCallable());

        Integer result = futureResult.get();

        System.out.println("Integer result from Future: " + result);

        executorService.shutdown();
    }
}
