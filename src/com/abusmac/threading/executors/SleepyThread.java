package com.abusmac.threading.executors;

import java.util.UUID;

public class SleepyThread extends Thread {
    private final int sleepMillis;
    private final long referenceStartPoint;
    private final UUID uuid;
    public SleepyThread(int sleepMillis, long referenceStartPoint) {
        this.sleepMillis = sleepMillis;
        this.referenceStartPoint = referenceStartPoint;
        this.uuid = UUID.randomUUID();
    }

    @Override
    public void run() {
        try {
            long current = System.currentTimeMillis();
            System.out.println("Thread: " + Thread.currentThread().getId() + "; Task Id: " + uuid + "; time: " + current + "; diff: " + (current - referenceStartPoint));

            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
