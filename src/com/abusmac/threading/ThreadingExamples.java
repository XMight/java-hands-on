package com.abusmac.threading;

public class ThreadingExamples implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        ThreadingExamples examples = new ThreadingExamples();
        Thread t = new Thread(examples);

        t.start();
    }

    @Override
    public void run() {
        Thread t = new Thread(new SomeRunnable(1000));
        Thread t2 = new Thread(new SomeRunnable(2000));

        t.start();
        t2.start();

        try {
            System.out.println("Before SomeRunnable 1: " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
            t.join();
            System.out.println("After SomeRunnable 1: " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
            t2.join();
            System.out.println("After SomeRunnable 2: " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of ThreadingExamples: " + Thread.currentThread().getId() + "; " + System.currentTimeMillis());
    }

    private static class SomeRunnable implements Runnable {
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
}
