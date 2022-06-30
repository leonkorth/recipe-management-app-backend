package htwberlin.webtech.recipemanagementapp.web;


import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeRepository;
import htwberlin.webtech.recipemanagementapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RecipeRestController {

    private final RecipeRepository recipeRepository;

    public RecipeRestController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Autowired
    RecipeService service;

    @PostMapping(path = "/api/v1/recipes")
    public RecipeEntity createRecipe(@RequestBody RecipeEntity recipeEntity){
        return service.createRecipe(recipeEntity);
    }

    @GetMapping(path = "/api/v1/recipes")
    public ResponseEntity<List<RecipeEntity>> fetchRecipes(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/api/v1/recipes/{id}")
    public RecipeEntity getRecipeByName(@PathVariable String id){
        return service.findById(Long.parseLong(id));
    }

    @GetMapping(path = "/api/v1/recipes", params = "ingredientId")
    public ResponseEntity<List<RecipeEntity>> getRecipeByIngredientId(@RequestParam String ingredientId){
        return ResponseEntity.ok(service.findRecipeByIngredient(Long.parseLong(ingredientId)));
    }

    @PutMapping(path = "/api/v1/recipes/{id}")
    public ResponseEntity<RecipeEntity> updateRecipe(@PathVariable Long id, @RequestBody RecipeEntity entity) {
        var recipe = service.updateRecipe(id, entity);
        return recipe != null? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        boolean successful = service.deleteRecipe(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
