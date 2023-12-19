package org.example.ProduserStockCustomer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class StockBlockingQueue {
    private final int MAX_CAPACITY = 10;
    private BlockingQueue<Products> stock = new ArrayBlockingQueue<>(MAX_CAPACITY, true);

    public StockBlockingQueue() {
    }

    public synchronized void put(){
        while (this.stock.size() == MAX_CAPACITY) {
            System.out.println("No way to put. Stock is full.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.stock.size() == 0){
            System.out.println("There is an opportunity to put product in the stock. Stock is empty");
            notifyAll();
        }
        Products product = new Products();
        stock.add(product);
        System.out.println("New product " + product + " put in the stock. Current count is " + this.stock.size());
    }

    public synchronized Products take(){
        while (this.stock.size() == 0) {
            System.out.println("Nothing to take. Stock is empty");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.stock.size() == MAX_CAPACITY){
            System.out.println("Stock is full");
            notifyAll();
        }
        Products product = this.stock.remove();
        System.out.println("Product " + product + " take from the stock . Current count is " + this.stock.size());
        return product;
    }
}
//Создайте реализацию программы Поставщик – Склад - Потребитель на основе блокирующей очереди