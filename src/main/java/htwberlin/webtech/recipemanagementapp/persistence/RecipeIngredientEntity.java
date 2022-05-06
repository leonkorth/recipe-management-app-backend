package htwberlin.webtech.recipemanagementapp.persistence;

import javax.persistence.*;

@Entity(name = "Recipe_Ingredient_Entity")
public class RecipeIngredientEntity {

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

}
