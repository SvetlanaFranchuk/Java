package org.example.ProduserStockCustomer;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private int id;
    private static int count = 1;

    private final StockBlockingQueue stock;
    public Producer(StockBlockingQueue stock) {
        this.id = count++;
        this.stock = stock;
    }

    @Override
    public void run() {
    while (true){
        stock.put();
        System.out.printf("Producer %d produced new product%n", this.id );
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
}
