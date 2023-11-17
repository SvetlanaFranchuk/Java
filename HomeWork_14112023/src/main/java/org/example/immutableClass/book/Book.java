package org.example.immutableClass.book;

import lombok.ToString;

@ToString
public final class Book {
    private final String name;
    private final String author;
    private final int yearPublication;

    public Book(String name, String author, int yearPublication) {
        this.name = name;
        this.author = author;
        this.yearPublication = yearPublication;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
