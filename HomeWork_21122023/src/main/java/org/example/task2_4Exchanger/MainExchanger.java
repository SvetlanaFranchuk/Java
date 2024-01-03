package org.example.task2_4Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ThreadLocalRandom;

public class MainExchanger {
    private static final Exchanger<Integer> EXCHANGER = new Exchanger<>();
    private static final int COUNT_THREAD = 4;
    public static void main(String[] args) {
        for (int i = 0; i < COUNT_THREAD; i++) {
            Thread producer = new Thread(() -> {
                try {
                    int number = ThreadLocalRandom.current().nextInt(10, 100);
                    System.out.println(Thread.currentThread().getName() + ": generated number " + number);

                    EXCHANGER.exchange(number);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Thread consumer = new Thread(() -> {
                try {
                    int numberReceived = EXCHANGER.exchange(null);
                    System.out.println(Thread.currentThread().getName() + ": double value receiving number "+
                            numberReceived +" is " + numberReceived*2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            producer.start();
            consumer.start();
        }
    }
}
