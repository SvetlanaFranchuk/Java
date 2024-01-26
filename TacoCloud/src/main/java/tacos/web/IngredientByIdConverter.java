package tacos.web;

import org.springframework.core.convert.converter.Converter;
import tacos.Ingredient;

import java.util.HashMap;
import java.util.Map;

public class IngredientByConverter implements Converter<String, Ingredient> {
    private Map<String, Ingredient> ingredientMap = new HashMap<>();
    public IngredientByIdConverter() {
        ingredientMap.put("FLTO",
}
