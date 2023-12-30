package com.abusmac.threading.synchronization;

import java.util.concurrent.Exchanger;

public class ExchangerMain {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        long start = System.currentTimeMillis();
        ExchangerThread exchangerThread1 = new ExchangerThread("t1", 100, exchanger, start);
        ExchangerThread exchangerThread2 = new ExchangerThread("t2", 500, exchanger, start);

        exchangerThread1.start();
        exchangerThread2.start();
    }

    private static class ExchangerThread extends Thread {
        private final String stringToExchange;
        private final Exchanger<String> exchanger;
        private final int sleep;
        private final long start;

        public ExchangerThread(String stringToExchange, int sleep, Exchanger<String> exchanger, long start) {
            this.stringToExchange = stringToExchange;
            this.exchanger = exchanger;
            this.sleep = sleep;
            this.start = start;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(sleep);
                long startSendMillis = System.currentTimeMillis();
                System.out.println("Thread: " + Thread.currentThread().getId() + "; sending string: " + stringToExchange + "; at: " + (startSendMillis - start));
                String received = this.exchanger.exchange(stringToExchange);
                long receiveMillis = System.currentTimeMillis();
                System.out.println("Thread: " + Thread.currentThread().getId() + "; received string: " + received + "; at: " + (receiveMillis - start));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
