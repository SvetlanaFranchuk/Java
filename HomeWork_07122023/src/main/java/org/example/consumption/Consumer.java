package org.example.consumption;

import org.example.inventoryControl.Product;
import org.example.inventoryControl.Stock;
import org.example.readProperties.Utils;

import java.time.LocalTime;

public class Consumer extends Thread {
    private Stock stock;

    public Consumer(int id, Stock stock) {
        super("Consumer " + id);
        this.stock = stock;
    }

    @Override
    public void run() {
        int consumerCount = Utils.getProperties("consumerCount");
        while (true) {
            for (int i = 0; i < consumerCount; i++) {
                try {
                    Product product = stock.getProduct();
                    System.out.printf(LocalTime.now() + "; № потока %d; тип потока %s; %s взял продукт №%s%n",
                            Thread.currentThread().getId(), Thread.currentThread().getName(), getName(), product.getId());
                    Thread.sleep(Utils.getProperties("consumerTime"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
