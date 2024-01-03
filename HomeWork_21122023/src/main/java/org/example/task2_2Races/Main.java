package org.example.task2_2Races;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int COUNT_RACES = 3;
    private static final int COUNT_PARTICIPANTS = 5;

    public static void main(String[] args) {
        for (int i = 1; i <= COUNT_RACES; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("Wait for the team");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            CountDownLatch latch = new CountDownLatch(COUNT_PARTICIPANTS);

            for (int j = 1; j <= COUNT_PARTICIPANTS; j++) {
                int finalJ = j;
                Thread thread = new Thread(()->{
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": participant " + finalJ + " is ready");
                    latch.countDown();
                });
                thread.start();
            }
            try {
                latch.await(7, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("All participants for race " + i + " are ready");
            System.out.printf("Race %d finished %n", i);
            System.out.println("");
        }
    }
}