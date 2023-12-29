package com.abusmac.threading.synchronization;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchThread extends Thread {
    private final long referenceStartPoint;
    private final CountDownLatch latch;
    public CountdownLatchThread(CountDownLatch latch, long referenceStartPoint) {
        this.referenceStartPoint = referenceStartPoint;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();

            long current = System.currentTimeMillis();
            System.out.println("Thread: " + Thread.currentThread().getId() + "; time: " + current + "; diff: " + (current - referenceStartPoint));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
