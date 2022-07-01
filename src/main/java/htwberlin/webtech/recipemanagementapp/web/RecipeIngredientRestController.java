package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.persistence.RecipeEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientPK;
import htwberlin.webtech.recipemanagementapp.service.RecipeIngredientService;
import htwberlin.webtech.recipemanagementapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RecipeIngredientRestController {

    @Autowired
    RecipeIngredientService service;

    @Autowired
    RecipeService recipeService;

    @PostMapping(path = "/api/v1/recipeIngredients")
    public RecipeIngredientEntity createRecipeIngredient(@Valid @RequestBody RecipeIngredientEntity recipeIngredientEntity){
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

    @PutMapping(path = "/api/v1/recipeIngredients/{rId}/{iId}")
    public ResponseEntity<RecipeIngredientEntity> updateRecipeIngredient(@PathVariable Long rId, @PathVariable Long iId, @RequestBody RecipeIngredientEntity entity) {
        var recipeIngredient = service.updateRecipeIngredient(rId, iId, entity);
        return recipeIngredient != null? ResponseEntity.ok(recipeIngredient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/recipeIngredients/{rId}/{iId}")
    public ResponseEntity<Void> deleteRecipeIngredient(@PathVariable Long rId, @PathVariable Long iId) {
        boolean successful = service.deleteRecipeIngredient(rId, iId);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
