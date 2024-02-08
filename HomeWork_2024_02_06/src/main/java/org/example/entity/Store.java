package org.example.entity;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class Store {
    private static Faker faker = new Faker();
    private List<Product> products;

    {
        products = new ArrayList<>();
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
        products.add(new Product(faker.commerce().productName()));
    }

    public List<Product> getListProduct(){
        return products;
    }

    public Product getProduct(int id){
        return products.stream().filter(p->p.getId()==id).findAny().orElse(null);
    }
}
