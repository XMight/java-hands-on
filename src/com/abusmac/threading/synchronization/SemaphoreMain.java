package com.abusmac.threading.synchronization;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {
    public static void main(String[] args) throws InterruptedException {
        Semaphore s = new Semaphore(3);

        long start = System.currentTimeMillis();

        SemaphoreThread t1 = new SemaphoreThread(1, s, start);
        SemaphoreThread t2 = new SemaphoreThread(2, s, start);
        SemaphoreThread t3 = new SemaphoreThread(3, s, start);
        SemaphoreThread t4 = new SemaphoreThread(4, s, start);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
