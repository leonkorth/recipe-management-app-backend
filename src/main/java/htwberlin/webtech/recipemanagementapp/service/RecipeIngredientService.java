package htwberlin.webtech.recipemanagementapp.service;

import htwberlin.webtech.recipemanagementapp.persistence.RecipeEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientEntity;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientPK;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class RecipeIngredientService {

    @Autowired
    RecipeIngredientRepository repository;

    public RecipeIngredientEntity createRecipeIngredient(RecipeIngredientEntity recipeIngredientEntity){
        return repository.save(recipeIngredientEntity);
    }

    public List<RecipeIngredientEntity> findAll(){
        return repository.findAll();
    }


    public List<RecipeIngredientEntity> findByRecipeId(RecipeEntity recipeEntity){
        return repository.findRecipeIngredientEntitiesByRecipeEntity(recipeEntity);
    }

}
