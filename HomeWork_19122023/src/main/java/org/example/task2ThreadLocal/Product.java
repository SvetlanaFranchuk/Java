package org.example.task2ThreadLocal;

public class Product {
    Integer gen;

    public Product() {
        this.gen = UniqueIdGenerator.generateUniqueId();
    }

    public Integer getGen() {
        return gen;
    }
}
