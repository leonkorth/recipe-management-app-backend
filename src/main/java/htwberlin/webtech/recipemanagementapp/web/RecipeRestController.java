package htwberlin.webtech.recipemanagementapp.web;


import htwberlin.webtech.recipemanagementapp.persistence.RecipeEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeRepository;
import htwberlin.webtech.recipemanagementapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class RecipeRestController {

    private final RecipeRepository recipeRepository;

    public RecipeRestController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Autowired
    RecipeService service;

    @PostMapping(path = "/api/v1/recipe")
    public RecipeEntity createRecipe(@RequestBody RecipeEntity recipeEntity){
        return service.createRecipe(recipeEntity);
    }

    @GetMapping("/api/v1/recipes")
    public ResponseEntity<List<RecipeEntity>> fetchRecipes(){
        return ResponseEntity.ok(service.findAll());
    }
}
