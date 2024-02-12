package org.example.dto;

import java.util.List;
import java.util.Map;

public class Dish {
    private String name;
    private Map<Ingredient, Integer> ingredientsToWeight;

    public Dish(String name, Map<Ingredient, Integer> ingredientsToWeight) {
        this.name = name;
        this.ingredientsToWeight = ingredientsToWeight;
    }

    public double calculatePrice(){
        return ingredientsToWeight.entrySet().stream()
                .mapToDouble(p-> p.getValue() * p.getKey().price()).sum();
    }

    public double calculateNutrition(){
        return ingredientsToWeight.entrySet().stream()
                .mapToInt(p-> p.getValue() * p.getKey().nutrition()).sum();
    }

    public String getName() {
        return name;
    }

    public Map<Ingredient, Integer> getIngredientsToWeight() {
        return ingredientsToWeight;
    }
}
