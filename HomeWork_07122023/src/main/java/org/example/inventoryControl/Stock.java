package org.example.inventoryControl;


import org.example.readProperties.Utils;

import java.time.LocalTime;
import java.util.Stack;

public class Stock {
    private Stack<Product> storage;
    private static final int STORAGE_SIZE = Utils.getProperties("storageSize");

    public Stock() {
        this.storage = new Stack<>();
    }

    public synchronized Product getProduct() {
        while (storage.isEmpty()) {
            try {
                System.out.printf(LocalTime.now() + "; № потока %d; тип потока %s; Склад пуст - ожидание%n",
                        Thread.currentThread().getId(), Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Product product = storage.stream().findFirst().orElseThrow();
        storage.pop();
        System.out.printf("Продукт №%d взят со склада. Количество продуктов на складе: %d %n",
                product.getId(), storage.size());
        notify();
        return product;
    }

    public synchronized void putProduct(Product product) {
        while (storage.size() == STORAGE_SIZE) {
            try {
                System.out.printf(LocalTime.now() + "; № потока %d; тип потока %s; Склад заполнен - ожидание%n",
                        Thread.currentThread().getId(), Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        storage.push(product);
        System.out.printf("Продукт №%d помещен на склад. Количество продуктов на складе: %d %n",
                product.getId(), storage.size());
        notify();
    }

}
