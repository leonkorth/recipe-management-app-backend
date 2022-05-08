package htwberlin.webtech.recipemanagementapp.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@IdClass(RecipeIngredientPK.class)
@Entity(name = "Recipe_Ingredient_Entity")
public class RecipeIngredientEntity implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipeId", referencedColumnName = "id")
    private RecipeEntity recipeEntity;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredientId", referencedColumnName = "id")
    private IngredientEntity ingredientEntity;
    @Column(name = "amount", nullable = false)
    private double amount;
    @Column(name = "unit", nullable = false)
    private String unit;

    public RecipeEntity getRecipeEntity() {return recipeEntity;}

    public IngredientEntity getIngredientEntity() {return ingredientEntity;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getUnit() {return unit;}
    public void setUnit(String unit) {this.unit = unit;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeIngredientEntity)) return false;
        //we can now assume o to be of the same type and want to access the types attributes
        RecipeIngredientEntity that = (RecipeIngredientEntity) o;
        return Objects.equals(getRecipeEntity(), that.getRecipeEntity()) &&
        Objects.equals(getIngredientEntity(), that.getIngredientEntity());}

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeEntity(), getIngredientEntity());
    }

}
