package com.abusmac.threading.synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        long start = System.currentTimeMillis();
        CyclicBarrierThread t1 = new CyclicBarrierThread(cyclicBarrier, start, 100);
        CyclicBarrierThread t2 = new CyclicBarrierThread(cyclicBarrier, start, 500);
        CyclicBarrierThread t3 = new CyclicBarrierThread(cyclicBarrier, start, 700);

        t1.start();
        t2.start();
        t3.start();

        cyclicBarrier.await();

        System.out.println("Exit main at: " + System.currentTimeMillis());
    }
}
