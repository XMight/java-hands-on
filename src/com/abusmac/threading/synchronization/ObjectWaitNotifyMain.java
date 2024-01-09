package com.abusmac.threading.synchronization;

public class ObjectWaitNotifyMain {
    public static void main(String[] args) {
        OverriddenObject o = new OverriddenObject();

        ObjectWaitingRunnable r1 = new ObjectWaitingRunnable(o);
        ObjectNotifyingRunnable r2 = new ObjectNotifyingRunnable(o);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }

    private record ObjectWaitingRunnable(OverriddenObject o) implements Runnable {
        @Override
            public void run() {
                try {
                    synchronized (o) {
                        System.out.println("Thread " + Thread.currentThread().getId() + ". Before waiting...");
                        System.out.println("Thread " + Thread.currentThread().getId() + ". Object value before wait: " + o.getValue());

                        o.wait();

                        System.out.println("Thread " + Thread.currentThread().getId() + ". Object value after wait: " + o.getValue());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    private record ObjectNotifyingRunnable(OverriddenObject o) implements Runnable {
        @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread " + Thread.currentThread().getId() + ". Before notify...");
                System.out.println("Thread " + Thread.currentThread().getId() + ". Object value before notify: " + o.getValue());

                synchronized (o) {
                    o.setValue(100);
                    o.notify();
                }
            }
        }

    private static class OverriddenObject {
        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

