package com.abusmac.threading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorsMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        SleepyThread t1 = new SleepyThread(1000, System.currentTimeMillis());
        SleepyThread t2 = new SleepyThread(1000, System.currentTimeMillis());

        executorService.submit(t1);
        executorService.submit(t2);

        executorService.shutdown();

        // Sleep to separate output logs
        Thread.sleep(2000);

        ExecutorService twoThreadsExecutorService = Executors.newFixedThreadPool(2);
        twoThreadsExecutorService.submit(t1);
        twoThreadsExecutorService.submit(t2);

        twoThreadsExecutorService.shutdown();
    }
}
