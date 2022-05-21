package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientPK;
import htwberlin.webtech.recipemanagementapp.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeIngredientRestController {

    @Autowired
    RecipeIngredientService service;

    @PostMapping(path = "/api/v1/recipeIngredients")
    public RecipeIngredientEntity createRecipeIngredient(@RequestBody RecipeIngredientEntity recipeIngredientEntity){
        return service.createRecipeIngredient(recipeIngredientEntity);
    }

    @GetMapping(path = "/api/v1/recipeIngredients")
    public ResponseEntity<List<RecipeIngredientEntity>> fetchRecipeIngredients(){
        return ResponseEntity.ok(service.findAll());
    }



}
