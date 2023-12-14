package org.example.inventoryControl;

public class Product {
    private final int id;
    private static int count = 0;

    public Product() {
        this.id = count++;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o == this || o != null &&
                o.getClass() == this.getClass() &&
                ((Product) o).id == this.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
