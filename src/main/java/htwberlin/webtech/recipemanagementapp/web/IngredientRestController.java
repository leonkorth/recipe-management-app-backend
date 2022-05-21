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
    public IngredientEntity getIngredientById(@PathVariable String id){
        return service.findById(Long.parseLong(id));
    }

    @GetMapping(path = "/api/v1/ingredients", params = "isVegetarian")
    public ResponseEntity<List<IngredientEntity>> getIngredientsByVegetarian(@RequestParam boolean isVegetarian){
        return ResponseEntity.ok(service.findByVegetarian(isVegetarian));
    }

    @GetMapping(path = "/api/v1/ingredients", params = "isVegan")
    public ResponseEntity<List<IngredientEntity>> getIngredientsByVegan(@RequestParam boolean isVegan){
        return ResponseEntity.ok(service.findByVegan(isVegan));
    }
    }
