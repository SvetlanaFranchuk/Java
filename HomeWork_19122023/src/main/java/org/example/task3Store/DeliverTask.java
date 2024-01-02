package org.example.task3Store;

import java.util.concurrent.atomic.AtomicInteger;

public class DeliverTask implements Runnable{
    OrderTask order;
    int id;

    public DeliverTask(OrderTask order, int id) {
        this.order = order;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Delivery order " + this.id + " for order " + order.getId() + " was created");
    }
}
