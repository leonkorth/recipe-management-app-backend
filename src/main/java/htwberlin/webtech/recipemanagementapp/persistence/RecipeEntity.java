package htwberlin.webtech.recipemanagementapp.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", unique = true, nullable = false)
    private String name;
    @Column(name="prep_time")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime prepTime;
    @Column(name = "servings")
    private int servings;
    @Column(name="instructions", nullable = false)
    private String instructions;
    @OneToMany(mappedBy = "recipeEntity", orphanRemoval = true)
    private List<RecipeIngredientEntity> recipeIngredientEntities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(LocalTime prepTime) {
        this.prepTime = prepTime;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
