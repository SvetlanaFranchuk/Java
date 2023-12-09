package org.example.trench;

public class MainDig {
    public static void main(String[] args) throws InterruptedException {
        Trench trench = new Trench(10);
        Digger digger1 = new Digger("Ivan");
        Digger digger2 = new Digger("John");
        long startTime = System.currentTimeMillis();

        Thread digger1Work = new Thread(digger1.doWork(trench), digger1.getName());
        Thread digger2Work = new Thread(digger2.doWork(trench),digger2.getName());
        digger1Work.start();
        digger2Work.start();
        digger1Work.join();
        digger2Work.join();
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - startTime) + " millisecond");

    }
}
