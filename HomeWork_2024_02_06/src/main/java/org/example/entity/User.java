package org.example.entity;

import com.github.javafaker.Faker;

public class User {
    private static Faker faker = new Faker();

    private String name;

    public User() {
        this.name = faker.name().fullName();
    }

    public String getName() {
        return name;
    }
}
