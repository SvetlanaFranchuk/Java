package org.example.task2Products;

import java.util.HashMap;
import java.util.Map;

public class MainProduct {
    public static void main(String[] args) {
        Map<Items, Integer> products = new HashMap<>();
        products.put(new Items("Ball", 1.35), 15);
        products.put(new Items("Treadmill", 180), 2);
        products.put(new Items("Dumbbell 5kg", 7.56), 5);
        products.put(new Items("Exercise bike", 125), 1);
        products.put(new Items("Rubberized wheels d-50 25kg", 12.78), 3);

        Map<Items, Integer> productsForOrder = getItemsForOrders(products);
        productsForOrder.forEach((k,v) ->
                System.out.println("Warning! It`s time to order " + k + ". The remainder is " + v));
     }

     public static Map <Items, Integer> getItemsForOrders(Map<Items, Integer> items){
        Map <Items, Integer> result = new HashMap<>();
        items.forEach((k,v) -> {
            if (v < 3) result.put(k,v);
            });
        return result;
     }
}
//Создайте класс Item с полями названия товара и стоимости товара. Создайте мапу, хранящую товар и соответствующее
// ему число единиц товара. С помощью метода forEach получите все товары, у которых осталось меньше 3 штук.