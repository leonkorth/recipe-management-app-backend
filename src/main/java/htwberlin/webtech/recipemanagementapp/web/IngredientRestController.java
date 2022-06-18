package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.IngredientRepository;
import htwberlin.webtech.recipemanagementapp.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientRestController {

    private final IngredientRepository ingredientRepository;

    public IngredientRestController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @Autowired
    IngredientService service;

    @PostMapping(path = "/api/v1/ingredients")
    public IngredientEntity createIngredient(@RequestBody IngredientEntity ingredientEntity) {
        return service.createIngredient(ingredientEntity);
    }

    @GetMapping(path = "/api/v1/ingredients")
    public ResponseEntity<List<IngredientEntity>> fetchIngredients(){
        return ResponseEntity.ok(ingredientRepository.findAll());
    }

    @GetMapping(path = "/api/v1/ingredients/{id}")
    public IngredientEntity getIngredientById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(path = "/api/v1/ingredients", params = "name")
    public ResponseEntity<IngredientEntity> getIngredientByName(@RequestParam String name){
        IngredientEntity ingredient = service.findByName(name);
        return ingredient != null? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/api/v1/ingredients", params = "isVegetarian")
    public ResponseEntity<List<IngredientEntity>> getIngredientsByVegetarian(@RequestParam boolean isVegetarian){
        return ResponseEntity.ok(service.findByVegetarian(isVegetarian));
    }

    @GetMapping(path = "/api/v1/ingredients", params = "isVegan")
    public ResponseEntity<List<IngredientEntity>> getIngredientsByVegan(@RequestParam boolean isVegan){
        return ResponseEntity.ok(service.findByVegan(isVegan));
    }

    @PutMapping(path = "/api/v1/ingredients/{id}")
    public ResponseEntity<IngredientEntity> updateIngredient(@PathVariable Long id, @RequestBody IngredientEntity entity) {
    var ingredient = service.updateIngredient(id, entity);
    return ingredient != null? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/ingredients/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        boolean successful = service.deleteIngredient(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
