package org.example.entity;

public class Product {

    private static int COUNT = 0;
    private String name;
    private int id;

    public Product(String name) {
        this.name = name;
        this.id = ++COUNT;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
