package org.example.task2ThreadLocal;

public class Client {
    Integer gen;

    public Client() {
        this.gen = UniqueIdGenerator.generateUniqueId();
    }

    public Integer getGen() {
        return gen;
    }
}
