package org.example.dto.cuisine;

import java.time.Duration;

public record Ingredient(String name, int nutrition, Duration cookingTime, double price) {


}
//Разработайте RESTful API для ресторана, которое принимает название блюда и возвращает информацию о блюде: ингредиенты,
// время приготовления, стоимость, пищевую ценность. Для простоты возвращайте заранее определенные данные.