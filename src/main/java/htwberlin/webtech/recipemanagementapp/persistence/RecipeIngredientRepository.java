package htwberlin.webtech.recipemanagementapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientEntity,Long> {

    List<RecipeIngredientEntity> findRecipeIngredientEntitiesByRecipeEntity(RecipeEntity recipeEntity);

    List<RecipeIngredientEntity> findRecipeIngredientEntitiesByIngredientEntity(IngredientEntity ingredientEntity);

    RecipeIngredientEntity findRecipeIngredientEntityByRecipeEntity_IdAndIngredientEntity_Id(Long rId, Long iId);
}
