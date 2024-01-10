package org.example;

import org.example.task1.Product;

public class MainTask2 {
    public static void main(String[] args) {
        Product product1 = new Product("apple", 1.45, 10, "Good apple");
        try {
            String json = WriteToJSON.serializeObject(product1);
            System.out.println(json);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }}
}