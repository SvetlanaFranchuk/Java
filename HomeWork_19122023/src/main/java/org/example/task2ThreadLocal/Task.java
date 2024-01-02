package org.example.task2ThreadLocal;

public class Task {
    Integer gen;

    public Task() {
        this.gen = UniqueIdGenerator.generateUniqueId();
    }

    public Integer getGen() {
        return gen;
    }
}
