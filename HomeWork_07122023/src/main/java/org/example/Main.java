package org.example;

import org.example.consumption.Consumer;
import org.example.inventoryControl.Stock;
import org.example.manufacture.Producer;
import org.example.readProperties.Utils;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        for (int i = 1; i <= Utils.getProperties("producerCount"); i++) {
            Producer producer = new Producer(i, stock);
            producer.start();
        }
        for (int i = 1; i <= Utils.getProperties("consumerCount"); i++) {
            Consumer consumer = new Consumer(i, stock);
            consumer.start();
        }
    }
}