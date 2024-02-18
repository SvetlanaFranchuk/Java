package org.example.mapper;

import org.example.dto.cuisine.Dish;
import org.example.dto.cuisine.DishDTO;
import org.springframework.stereotype.Component;

@Component
public class DishMapper {

    public DishDTO toDishDTO (Dish dish){
        return new DishDTO(dish.getName(), dish.getIngredientsToWeight().keySet(), dish.calculateTime().toMinutes(),
                dish.calculatePrice(), dish.calculateNutrition());
    }

}
