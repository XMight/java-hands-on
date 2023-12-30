package com.abusmac.threading.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread {
    private final CyclicBarrier cyclicBarrier;
    private final long referenceStartPoint;
    private final long waitMillis;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier, long start, long waitMillis) {
        this.cyclicBarrier = cyclicBarrier;
        this.referenceStartPoint = start;
        this.waitMillis = waitMillis;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting: " + waitMillis);

            Thread.sleep(waitMillis);
            
            cyclicBarrier.await();

            long current = System.currentTimeMillis();
            System.out.println("Thread: " + Thread.currentThread().getId() + "; time: " + current + "; diff: " + (current - referenceStartPoint));
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
