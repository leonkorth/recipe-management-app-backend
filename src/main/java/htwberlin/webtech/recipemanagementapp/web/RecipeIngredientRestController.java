package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientPK;
import htwberlin.webtech.recipemanagementapp.service.RecipeIngredientService;
import htwberlin.webtech.recipemanagementapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeIngredientRestController {

    @Autowired
    RecipeIngredientService service;

    @Autowired
    RecipeService recipeService;

    @PostMapping(path = "/api/v1/recipeIngredients")
    public RecipeIngredientEntity createRecipeIngredient(@RequestBody RecipeIngredientEntity recipeIngredientEntity){
        return service.createRecipeIngredient(recipeIngredientEntity);
    }

    @GetMapping(path = "/api/v1/recipeIngredients")
    public ResponseEntity<List<RecipeIngredientEntity>> fetchRecipeIngredients(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/api/v1/recipeIngredients", params = "recipeId")
    public ResponseEntity<List<RecipeIngredientEntity>> getRecipeIngredientByRecipeId(@RequestParam Long recipeId){
        return ResponseEntity.ok(service.findByRecipeId(recipeService.findById(recipeId))) ;
    }



}
