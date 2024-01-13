package org.example.task1;

import java.util.Objects;

public class Book implements Comparable {
    String name;
    double price;
    boolean isPresent;

    public Book(String name, double price, boolean isPresent) {
        this.name = name;
        this.price = price;
        this.isPresent = isPresent;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPresent() {
        return isPresent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
               (Double.compare(book.price, price) != 0) &&
               (isPresent != book.isPresent);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (isPresent ? 1 : 0);
        return result;
    }


    @Override
    public int compareTo(Object o) {
        Book book = (Book) o;
        int result = this.name.compareTo(book.name);
        if (result == 0){
            result = Double.compare(this.price, book.price);
        }
        if (result == 0){
            result = Boolean.compare(this.isPresent, book.isPresent);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isPresent=" + isPresent +
                '}' + "\n";
    }
}
//Для класса Book с полями String name, double price, boolean isPresent
//реализовать методы equals(Object o), hashCode(), compareTo(Book another)