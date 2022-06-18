package htwberlin.webtech.recipemanagementapp.service;

import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.IngredientRepository;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientService{

    @Autowired
    IngredientRepository repository;
    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    public IngredientEntity createIngredient(IngredientEntity ingredientEntity) {
        return repository.save(ingredientEntity);
    }

    public List<IngredientEntity> findByVegetarian(boolean isVegetarian) {
        return repository.findIngredientEntitiesByVegetarian(isVegetarian);
    }

    public List<IngredientEntity> findByVegan(boolean isVegan) {
        return repository.findByVegan(isVegan);
    }

    public IngredientEntity findById(Long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public IngredientEntity findByName(String name) {
        var ingredientEntity = repository.findFirstByName(name);
        return ingredientEntity.isPresent()? ingredientEntity.get() : null;
    }

    public IngredientEntity updateIngredient(Long id, IngredientEntity entity) {
        var ingredientEntityOptional = repository.findById(id);
        if (ingredientEntityOptional.isEmpty()) {
            return null;
        }
        var ingredientEntity = ingredientEntityOptional.get();
        ingredientEntity.setName(entity.getName());
        ingredientEntity.setVegetarian(entity.isVegetarian());
        ingredientEntity.setVegan(entity.isVegan());
        ingredientEntity = repository.save(ingredientEntity);
        return ingredientEntity;
    }

    public boolean deleteIngredient (Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        if(recipeIngredientRepository.findRecipeIngredientEntitiesByIngredientEntity(findById(id)).isEmpty()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
