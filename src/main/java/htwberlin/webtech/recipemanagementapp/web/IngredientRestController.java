package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.web.api.Ingredient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientRestController {

    private List<Ingredient> ingredients;

    public IngredientRestController() {
        ingredients = new ArrayList<>();
        ingredients.add((new Ingredient(1,"sugar",100, true)));
        ingredients.add((new Ingredient(2,"milk",20, false)));

    }

    @GetMapping(path = "/api/v1/ingredient")
    public ResponseEntity<List<Ingredient>> fetchIngredients(){
        return ResponseEntity.ok(ingredients);
    }

}
