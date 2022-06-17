package htwberlin.webtech.recipemanagementapp.service;

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
    public void deleteRecipe(RecipeEntity recipeEntity) {
        repository.delete(recipeEntity);
    }

    public List<RecipeEntity> findAll(){
        return repository.findAll();
    }
    public RecipeEntity findById(Long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<RecipeEntity> findRecipeByIngredient(Long ingredientId){

        return  recipeIngredientService.findAll()
                .stream()
                .filter(x -> Objects.equals(x.getIngredientEntity().getId(), ingredientId)
                                && Objects.equals(x.getId().getIngredientId(), ingredientId)
                        )
                .map(RecipeIngredientEntity::getRecipeEntity)
                .toList();
    }


}
