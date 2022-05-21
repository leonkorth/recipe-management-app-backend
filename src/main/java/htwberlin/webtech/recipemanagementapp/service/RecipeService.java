package htwberlin.webtech.recipemanagementapp.service;

import htwberlin.webtech.recipemanagementapp.persistence.RecipeEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public RecipeEntity createRecipe(RecipeEntity recipeEntity){
        return repository.save(recipeEntity);
    }

    public List<RecipeEntity> findAll(){
        return repository.findAll();
    }
}
