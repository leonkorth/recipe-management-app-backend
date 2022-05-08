package htwberlin.webtech.recipemanagementapp.service;

import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientService {

    @Autowired
    IngredientRepository repository;

    public IngredientEntity createIngredient(IngredientEntity ingredientEntity) {
        return repository.save(ingredientEntity);
    }

    public List<IngredientEntity> findAllVegetarian() {
        return repository.findIngredientEntitiesByVegetarian(true);
    }

    public List<IngredientEntity> findAllVegan() {
        return repository.findIngredientEntitiesByVegan(true);
    }
}
