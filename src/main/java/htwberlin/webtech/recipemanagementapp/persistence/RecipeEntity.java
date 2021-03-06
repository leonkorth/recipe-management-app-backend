package htwberlin.webtech.recipemanagementapp.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Recipe")
public class RecipeEntity {
    //test
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", unique = true, nullable = false)
    @NotBlank(message = "the name must not be empty")
    @Size(min = 3, max = 30, message = "please provide a name between 3 and 30 characters ")
    private String name;
    @Column(name="prep_time")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime prepTime;
    @Column(name = "servings")
    @Min(value = 1, message = "the value must be equal or higher 1")
    @Max(value = 1000, message = "the value must be equal or less 1000")
    private int servings;
    @Column(name="instructions", nullable = false, length = 1000)
    @Size(min = 1, max = 999, message = "please provide instructions between 1 and 999 characters ")
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

    public RecipeEntity(Long id, String name, LocalTime prepTime, int servings, String instructions) {
        this.id = id;
        this.name = name;
        this.prepTime = prepTime;
        this.servings = servings;
        this.instructions = instructions;
    }

    public RecipeEntity() {
    }

    @Override
    public String toString() {
        return "RecipeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prepTime=" + prepTime +
                ", servings=" + servings +
                ", instructions='" + instructions + '\'' +
                ", recipeIngredientEntities=" + recipeIngredientEntities +
                '}';
    }
}
