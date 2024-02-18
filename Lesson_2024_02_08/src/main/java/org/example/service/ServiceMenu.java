package org.example.service;

import org.example.dto.cuisine.Dish;
import org.example.dto.cuisine.DishDTO;
import org.example.dto.cuisine.Ingredient;
import org.example.mapper.DishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

@Service
public class ServiceMenu {
    private Set<Dish> menu;

    private DishMapper dishMapper;
    @Autowired
    public ServiceMenu(DishMapper dishMapper) {
        this.menu = new HashSet<>(Set.of(
                new Dish("French Potato", Map.of(new Ingredient("Potato", 200, Duration.ofMinutes(20), 2.0), 500)),
                new Dish("French Potato2", Map.of(new Ingredient("Potato", 200, Duration.ofMinutes(20), 2.0), 500))
        ));
        this.dishMapper = dishMapper;
    }

    public DishDTO getByName(String name){
        Dish dish = menu.stream().filter(d-> Objects.equals(d.getName(),name))
                .findFirst().orElseThrow();
        return dishMapper.toDishDTO(dish);
    }
}
