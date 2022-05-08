package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.IngredientRepository;
import htwberlin.webtech.recipemanagementapp.service.IngredientService;
import htwberlin.webtech.recipemanagementapp.web.api.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IngredientRestController {

    private final IngredientRepository ingredientRepository;

    public IngredientRestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @Autowired
    IngredientService service;

    @PostMapping(path = "/api/v1/ingredient")
    public IngredientEntity createIngredient(@RequestBody IngredientEntity ingredientEntity) {
        return service.createIngredient(ingredientEntity);
    }

    @GetMapping(path = "/api/v1/ingredients")
    public ResponseEntity<List<IngredientEntity>> fetchIngredients(){
        return ResponseEntity.ok(ingredientRepository.findAll());
    }

}
