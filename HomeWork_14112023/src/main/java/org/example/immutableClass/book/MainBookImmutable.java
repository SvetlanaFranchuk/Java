package org.example.immutableClass.book;

import java.util.ArrayList;
import java.util.List;

public class MainBookImmutable {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 2000);
        Book book2 = new Book("The adventures of Tom Sawyer", "Mark Twain", 1997);
        Book book3 = new Book(book2.getName(), book2.getAuthor(), 2004);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        for (Book b:books) {
            System.out.println(b);
        }


    }
}
