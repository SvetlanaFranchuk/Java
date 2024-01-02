package org.example.task3Store;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<OrderTask> orders = new CopyOnWriteArrayList<>();
        List<DeliverTask> delivers = new ArrayList<>();
        ScheduledExecutorService delivery = Executors.newScheduledThreadPool(2);
        int countOrders = ThreadLocalRandom.current().nextInt(5,11);
        for (int i = 0; i < countOrders; i++) {
            int finalId = i;
            service.execute(() -> {
                orders.add(new OrderTask(finalId));
                System.out.println(Thread.currentThread().getName() + ": Order " + finalId + " was created");
           });
        }
        try {
            service.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Count orders " + orders.size());
        for (OrderTask o : orders) {
            DeliverTask d = new DeliverTask(o, o.getId());
            delivers.add(d);
            delivery.schedule(d, 4, TimeUnit.SECONDS);
        }
        service.shutdown();
        delivery.shutdown();
    }
}
