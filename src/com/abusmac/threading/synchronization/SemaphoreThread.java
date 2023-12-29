package com.abusmac.threading.synchronization;

import java.util.concurrent.Semaphore;

public class SemaphoreThread extends Thread {
    private final int i;
    private final Semaphore semaphore;

    private final long referenceStartPoint;

    public SemaphoreThread(int i, Semaphore s, long referenceStartPoint) {
        this.i = i;
        this.semaphore = s;
        this.referenceStartPoint = referenceStartPoint;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();

            long current = System.currentTimeMillis();
            System.out.println("Thread: " + Thread.currentThread().getId() + "; i : " + i + "; time: " + current + "; diff: " + (current - referenceStartPoint));

            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }
}
