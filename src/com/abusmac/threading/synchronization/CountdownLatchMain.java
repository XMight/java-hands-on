package com.abusmac.threading.synchronization;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchMain {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        long start = System.currentTimeMillis();

        System.out.println("Start: " + start);

        CountdownLatchThread t1 = new CountdownLatchThread(latch, start);
        CountdownLatchThread t2 = new CountdownLatchThread(latch, start);
        CountdownLatchThread t3 = new CountdownLatchThread(latch, start);

        t1.start();
        t2.start();
        t3.start();

        for(int i = 0; i < 3; i++) {
            Thread.sleep(100);

            latch.countDown();
        }
    }
}
