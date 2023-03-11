package com.busmac.threading;

public class ThreadingExamples implements Runnable {
    @Override
    public void run() {
        Thread t = new Thread(new SomeRunnable(4000));
        Thread t2 = new Thread(new SomeRunnable(7000));

        t.start();
        t2.start();

        try {
            t.join();
            System.out.println("After SomeRunnable 1: " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
            t2.join();
            System.out.println("After SomeRunnable 2: " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of ThreadingExamples: " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
    }
}
