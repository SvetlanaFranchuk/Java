package org.example.dto.cuisine;

import java.util.Set;

public record DishDTO (String name, Set<Ingredient> ingredients, long cookingTime, double price, int nutrition){
}
