package htwberlin.webtech.recipemanagementapp.persistence;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Objects;


@Entity(name = "Recipe_Ingredient_Entity")
public class RecipeIngredientEntity implements Serializable {

    @EmbeddedId
    RecipeIngredientPK id;

    @ManyToOne(fetch = FetchType.EAGER)
    private RecipeEntity recipeEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    private IngredientEntity ingredientEntity;

    @Column(name = "amount", nullable = false)
    @NotNull
    @PositiveOrZero(message = "value must be positive or zero")
    private double amount;
    @Column(name = "unit", nullable = false)
    @NotNull(message = "value must not be null")
    private String unit;

    public RecipeIngredientPK getId() {
        return id;
    }

    public void setId(RecipeIngredientPK id) {
        this.id = id;
    }

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredientEntity that = (RecipeIngredientEntity) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(id, that.id) && Objects.equals(recipeEntity, that.recipeEntity) && Objects.equals(ingredientEntity, that.ingredientEntity) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, recipeEntity, ingredientEntity, amount, unit);
    }

    public RecipeIngredientEntity(RecipeIngredientPK id, RecipeEntity recipeEntity, IngredientEntity ingredientEntity, double amount, String unit) {
        this.id = id;
        this.recipeEntity = recipeEntity;
        this.ingredientEntity = ingredientEntity;
        this.amount = amount;
        this.unit = unit;
    }

    public RecipeIngredientEntity() {
    }

    @Override
    public String toString() {
        return "RecipeIngredientEntity{" +
                "id=" + id +
                ", recipeEntity=" + recipeEntity +
                ", ingredientEntity=" + ingredientEntity +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                '}';
    }
}
