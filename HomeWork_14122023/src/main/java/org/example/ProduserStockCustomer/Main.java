package org.example.ProduserStockCustomer;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        StockBlockingQueue stock = new StockBlockingQueue();
        int countProducer = ThreadLocalRandom.current().nextInt(1, 5);
        int countCustomer = ThreadLocalRandom.current().nextInt(1, 5);
        for (int i = 0; i < countProducer; i++) {
            new Thread(new Producer(stock)).start();
        }
        for (int i = 0; i < countCustomer; i++) {
            new Thread(new Customer(stock)).start();
        }
     }
}
