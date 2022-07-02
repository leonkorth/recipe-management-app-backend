package htwberlin.webtech.recipemanagementapp.service;

import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    @Autowired
    private RecipeIngredientService recipeIngredientService;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public RecipeEntity createRecipe(RecipeEntity recipeEntity){
        return repository.save(recipeEntity);
    }

    public RecipeEntity updateRecipe(Long id, RecipeEntity entity) {
        var recipeEntityOptional = repository.findById(id);
        if (recipeEntityOptional.isEmpty()) {
            return null;
        }
        var recipeEntity = recipeEntityOptional.get();
        recipeEntity.setName(entity.getName());
        recipeEntity.setPrepTime(entity.getPrepTime());
        recipeEntity.setServings(entity.getServings());
        recipeEntity.setInstructions(entity.getInstructions());
        recipeEntity = repository.save(recipeEntity);
        return recipeEntity;
    }

    public boolean deleteRecipe(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public List<RecipeEntity> findAll(){
        return repository.findAll();
    }
    public RecipeEntity findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public List<RecipeEntity> findRecipeByIngredient(Long ingredientId){

        return recipeIngredientService.findAll()
                .stream()
                .filter(x -> Objects.equals(x.getIngredientEntity().getId(), ingredientId)
                        && Objects.equals(x.getId().getIngredientId(), ingredientId)
                )
                .map(RecipeIngredientEntity::getRecipeEntity)
                .toList();
    }


}
