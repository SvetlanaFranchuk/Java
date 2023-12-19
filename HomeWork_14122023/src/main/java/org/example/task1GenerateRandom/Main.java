package org.example.task1GenerateRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        AtomicLong sum = new AtomicLong(0);
        AtomicBoolean isEnough = new AtomicBoolean(false);

        while (!isEnough.get()) {
            for (int i = 0; i <= 10; i++) {
                Thread thread = new Thread(() -> {
                    int number = ThreadLocalRandom.current().nextInt(1000, 3000);
                    try {
                        Thread.sleep(number);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    sum.getAndAdd(number);
                });
                threads.add(thread);
                thread.start();
            }
            for (Thread t : threads) {
                if (isEnough.get()) t.interrupt();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (sum.get() > 1_000_000) isEnough.set(true);
            System.out.println("Sum = " + sum.get());
        }
    }
}
// Создайте 10 потоков, каждый из которых «делает вычисления» (генерирует случайное число,
// ждёт сгенерированное число миллисекунд, добавляет сгенерированное число в общую для всех потоков переменную).
// Используя AtomicBoolean, создайте флаг, указывающий на возможность завершения приложения.
// Когда потоки накопят в общей переменной число 1000000 флаг становится true.