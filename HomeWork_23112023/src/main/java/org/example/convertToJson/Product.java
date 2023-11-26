package org.example.convertToJson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private ProductsType type;
    private String article;
    private String model;

    @Override
    public String toString() {
        return "{" +
                "type=" + type +
                ", article='" + article + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
