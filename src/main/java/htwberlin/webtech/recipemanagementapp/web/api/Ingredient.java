package htwberlin.webtech.recipemanagementapp.web.api;

public class Ingredient {

    private long id;
    private String name;
    private int calories;
    private boolean isVegan;

    public Ingredient(long id, String name, int calories, boolean isVegan) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.isVegan = isVegan;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }
}
