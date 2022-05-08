package htwberlin.webtech.recipemanagementapp.persistence;

import java.io.Serializable;
import java.util.Objects;

public class RecipeIngredientPK implements Serializable {
    private RecipeEntity recipeEntity;
    private IngredientEntity ingredientEntity;

    public RecipeEntity getRecipeEntity() {
        return recipeEntity;
    }

    public void setRecipeEntity(RecipeEntity recipeEntity) {
        this.recipeEntity = recipeEntity;
    }

    public IngredientEntity getIngredientEntity() {
        return ingredientEntity;
    }

    public void setIngredientEntity(IngredientEntity ingredientEntity) {
        this.ingredientEntity = ingredientEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientPK)) return false;
        //we can now assume o to be of the same type and want to access the types attributes
        RecipeIngredientPK that = (RecipeIngredientPK) o;
        return Objects.equals(getRecipeEntity(), that.getRecipeEntity()) &&
                Objects.equals(getIngredientEntity(), that.getIngredientEntity());}

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeEntity(), getIngredientEntity());
    }
}




