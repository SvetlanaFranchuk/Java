package org.example.task2_3Robot;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainLine {
    private static final int COUNT_PROCESSES = 5;
    private static final int COUNT_LINES = 2;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(COUNT_PROCESSES);
    public static void main(String[] args) {

        Arrays.stream(new int[COUNT_PROCESSES]).mapToObj(a-> new Thread(()->{
                    System.out.println(Thread.currentThread().getName() + " started process ");
                    for (int i = 0; i < COUNT_LINES ; i++) {
                        System.out.println(Thread.currentThread().getName() + " line " + i);
                        try {
                            BARRIER.await();
                        } catch (InterruptedException| BrokenBarrierException e) {
                           e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + " finished process");
                }))
                .forEach(Thread::start);
    }
}
