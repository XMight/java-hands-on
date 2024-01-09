package com.abusmac.threading.synchronization;

import java.util.concurrent.Phaser;

public class PhaserMain {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        phaser.register();

        long currentTimeMillis = System.currentTimeMillis();
        PhaserThread pt1 = new PhaserThread(phaser, currentTimeMillis, 500);

        PhaserThread pt2 = new PhaserThread(phaser, currentTimeMillis, 200);

        PhaserThread pt3 = new PhaserThread(phaser, currentTimeMillis, 100);

        pt1.start();
        pt2.start();
        pt3.start();

        do {
            int phase = phaser.getPhase();

            System.out.println("Awaiting next phase. Phase in main: " + phase);
            System.out.println("Registered parties:" + phaser.getRegisteredParties());

            phaser.arriveAndAwaitAdvance();

        } while (phaser.getRegisteredParties() != 1);

        System.out.println("Registered parties: " + phaser.getRegisteredParties());
        System.out.println("Last phase: " + phaser.getPhase());

        phaser.arriveAndDeregister();

        System.out.println("Registered parties: " + phaser.getRegisteredParties());
        System.out.println("Phase after no parties registered: " + phaser.getPhase());

    }

    private static class PhaserThread extends Thread {
        private final long referenceStartPoint;
        private final Phaser phaser;

        private int sleep;

        public PhaserThread(Phaser phaser, long referenceStartPoint, int sleep) {
            this.referenceStartPoint = referenceStartPoint;
            this.phaser = phaser;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            this.phaser.register();

            try {
                System.out.println("Thread: " + Thread.currentThread().getId() + "; Arriving and waiting for others: " + phaser.getPhase());

                Thread.sleep(sleep);
                phaser.arriveAndAwaitAdvance();

                System.out.println("Thread: " + Thread.currentThread().getId() + "; Arriving and waiting for others: " + phaser.getPhase());

                Thread.sleep(sleep);
                phaser.arriveAndAwaitAdvance();

                System.out.println("Thread: " + Thread.currentThread().getId() + "; Arriving and waiting for others: " + phaser.getPhase());

                Thread.sleep(sleep);
                phaser.arriveAndAwaitAdvance();

                System.out.println("Thread: " + Thread.currentThread().getId() + "; Arriving and unregistering, phase: " + phaser.getPhase());
                phaser.arriveAndDeregister();

                long current = System.currentTimeMillis();
                System.out.println("Thread: " + Thread.currentThread().getId() + "; time: " + current + "; diff: " + (current - referenceStartPoint));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
