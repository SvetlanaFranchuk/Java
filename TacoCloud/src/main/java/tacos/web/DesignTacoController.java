package tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", TypeIngredients.WRAP),
                new Ingredient("COTO", "Corn Tortilla", TypeIngredients.WRAP),
                new Ingredient("GRBF", "Ground Beef", TypeIngredients.PROTEIN),
                new Ingredient("CARN", "Carnitas", TypeIngredients.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", TypeIngredients.VEGGIES),
                new Ingredient("LETC", "Lettuce", TypeIngredients.VEGGIES),
                new Ingredient("CHED", "Cheddar", TypeIngredients.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", TypeIngredients.CHEESE),
                new Ingredient("SLSA", "Salsa", TypeIngredients.SAUCE),
                new Ingredient("SRCR", "Sour Cream", TypeIngredients.SAUCE)
                );
    TypeIngredients[] types = TypeIngredients.values();
        for (int i = 0; i < types.length ; i++) {
            model.addAllAttributes(types[i].toString().toLowerCase(),
                    filterByType(ingredients, types[i]));
        }
    }

    @ModelAttribute(name="tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @ModelAttribute(name="taco")
    public Taco taco(){
        return  new Taco();
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, TypeIngredients type){
        return ingredients.stream()
                .filter(x->x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
