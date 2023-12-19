package org.example.ProduserStockCustomer;

public class Products {
    private int id;
    private static int count = 1;


    public Products() {
        this.id = count++;
    }
    @Override
    public String toString() {
        return " vendor code " + id;
    }
}
