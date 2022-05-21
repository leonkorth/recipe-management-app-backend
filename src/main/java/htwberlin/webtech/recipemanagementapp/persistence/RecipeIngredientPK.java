package htwberlin.webtech.recipemanagementapp.persistence;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RecipeIngredientPK implements Serializable {

    private Long recipeId;
    private Long ingredientId;

    public Long getRecipeId() {


        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredientPK that = (RecipeIngredientPK) o;
        return Objects.equals(recipeId, that.recipeId) && Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, ingredientId);
    }


    public RecipeIngredientPK(Long recipeId, Long ingredientId) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
    }

    public RecipeIngredientPK() {
    }

    @Override
    public String toString() {
        return "RecipeIngredientPK{" +
                "recipeId=" + recipeId +
                ", ingredientId=" + ingredientId +
                '}';
    }
}