package com.abusmac.threading.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        SomeLockClass lockClass = new SomeLockClass();

        SomeLockThread t1 = new SomeLockThread(lockClass);
        SomeLockThread t2 = new SomeLockThread(lockClass);

        executorService.submit(t1);
        executorService.submit(t2);

        executorService.shutdown();
    }

    private static class SomeLockClass {
        private final Lock lock;

        private int i;

        public SomeLockClass() {
            this.lock = new ReentrantLock();
            i = 100;
        }

        int getIntWithMultiply() throws InterruptedException {
            try {
                lock.lock();

                Thread.sleep(100);
                i = i * 3;
            } finally {
                lock.unlock();
            }

            return i;
        }
    }

    private static class SomeLockThread extends Thread {
        private final SomeLockClass someLockClass;
        public SomeLockThread(SomeLockClass someLockClass) {
            this.someLockClass = someLockClass;
        }

        @Override
        public void run() {
            int result = 0;
            try {
                result = someLockClass.getIntWithMultiply();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread: " + Thread.currentThread().getId() + "; Result: " + result);
        }
    }
}
