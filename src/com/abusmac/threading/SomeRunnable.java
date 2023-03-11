package com.abusmac.threading;

public class SomeRunnable implements Runnable {
    int sleep;

    public SomeRunnable(int sleep) {
        this.sleep = sleep;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleep);
            System.out.println("SomeRunnable " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}