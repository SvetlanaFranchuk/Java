package org.example.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("J.K. Rowling Harry Potter", 9.99, true);
        Book book2 = new Book("J.K. Rowling Harry Potter Part 2", 11.15, true);
        Book book3 = new Book("J.K. Rowling Harry Potter", 9.98, true);
        Book book4 = new Book("J.K. Rowling Harry Potter", 9.98, false);

        System.out.println(book1.equals(book2));
        System.out.println("book1.hashCode " + book1.hashCode());
        System.out.println("book2.hashCode " + book2.hashCode());

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        Collections.sort(books);

        System.out.println(books);
    }
}