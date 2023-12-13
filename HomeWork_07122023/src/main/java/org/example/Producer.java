package org.example;

public class Producer extends Thread {
    private Stock stock;

    public Producer(int id, Stock stock) {
        super("Producer " + id);
        this.stock = stock;
    }

    @Override
    public void run() {
        int producerCount = Utils.getProperties("producerCount");
        while (true) {
            for (int i = 0; i < producerCount; i++) {
                try {
                    Product product = new Product();
                    stock.putProduct(new Product());
                    System.out.printf("Producer %s make %s product%n", getName(), product.getId());
                    Thread.sleep(Utils.getProperties("producerTime"));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
