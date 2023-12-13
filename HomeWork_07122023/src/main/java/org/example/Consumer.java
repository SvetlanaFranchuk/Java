package org.example;

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
                    System.out.printf("Consumer %s take %s product%n", getName(), product.getId());
                    Thread.sleep(Utils.getProperties("consumerTime"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
