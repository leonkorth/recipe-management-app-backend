package htwberlin.webtech.recipemanagementapp.service;

import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientService{

    @Autowired
    IngredientRepository repository;

    public IngredientEntity createIngredient(IngredientEntity ingredientEntity) {
        return repository.save(ingredientEntity);
    }

    public List<IngredientEntity> findByVegetarian(boolean isVegetarian) {
        return repository.findIngredientEntitiesByVegetarian(isVegetarian);
    }

    public List<IngredientEntity> findByVegan(boolean isVegan) {
        return repository.findIngredientEntitiesByVegan(isVegan);
    }

    public IngredientEntity findById(Long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }




}
