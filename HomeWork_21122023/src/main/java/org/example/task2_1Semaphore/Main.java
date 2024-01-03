package org.example.task2_1Semaphore;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class Main {

    private static final int THREAD_COUNT = 100;
    private static final Semaphore SEMAPHORE = new Semaphore(2);
    public static void main(String[] args) {
        List<String> dateTest = new CopyOnWriteArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i <= THREAD_COUNT; i++) {
            Thread thread = new Thread(()->{
                try {
                    SEMAPHORE.acquire();
                    String str = faker.artist().name().toString();
                    dateTest.add(str);
                    System.out.println(Thread.currentThread().getName()+ ": wrote next line to dateBase: " + str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    SEMAPHORE.release();
                    System.out.println(Thread.currentThread().getName()+ ": has released the resource.");
                }
            });
            thread.start();
        }

    }
}
