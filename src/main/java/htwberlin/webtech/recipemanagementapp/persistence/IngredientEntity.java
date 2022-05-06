package htwberlin.webtech.recipemanagementapp.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "vegetarian")
    private boolean vegetarian;
    @Column(name = "vegan")
    private boolean vegan;
    @OneToMany(mappedBy = "ingredientEntity", orphanRemoval = true)
    private List<RecipeIngredientEntity> recipeIngredientEntities = new ArrayList<>();

    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public boolean isVegetarian() {return vegetarian;}

    public void setVegetarian(boolean vegetarian) {
        if (!vegetarian) {this.setVegan(false);} //if ingredient is not vegetarian, it cannot be vegan
        this.vegetarian = vegetarian;
    }

    public boolean isVegan() {return vegan;}

    public void setVegan(boolean vegan) {
        if (vegan) {this.setVegetarian(true);}
        this.vegan = vegan;
    }
}
