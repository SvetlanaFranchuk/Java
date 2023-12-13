package org.example;


import java.util.Properties;
import java.util.Stack;

public class Stock {
    private Stack<Product> storage;
    private static final int STORAGE_SIZE = Utils.getProperties("storageSize");
    public Stock(int size) {
        this.storage = new Stack<>();
    }

    public synchronized Product getProduct(){
        while (storage.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Product product = storage.stream().findFirst().orElseThrow();
        storage.pop();
        System.out.printf("Product %d get from the stock%n", product.getId());
        notify();
        return product;
    }

     public synchronized void putProduct(Product product){
        while (storage.size() == STORAGE_SIZE){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        storage.push(product);
        System.out.printf("Product %d is placed in the stock%n", product.getId());
        notify();
    }

}
