package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.persistence.RecipeEntity;
import htwberlin.webtech.recipemanagementapp.service.RecipeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RecipeRestController.class)
class RecipeRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    @DisplayName("should return 404 if recipe is not found")
    void findNonExistingRecipe() throws Exception {

        doReturn(null).when(recipeService).findById(10L);mockMvc.perform(get("/api/v1/recipes/10"))
                // then
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("should return all recipes in json format")
    void findAllRecipes() throws Exception {


        var recipeEntities = List.of(
                new RecipeEntity(10L,"Schnitzel", LocalTime.of(1,2,3),3, "Anleitung1"),
                new RecipeEntity(20L,"Pommes", LocalTime.of(10,20,30),6, "Anleitung2")
        );

        doReturn(recipeEntities).when(recipeService).findAll();

        // when
        mockMvc.perform(get("/api/v1/recipes"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(10))
                .andExpect(jsonPath("$[0].name").value("Schnitzel"))
                .andExpect(jsonPath("$[0].prepTime").value("01:02:03"))
                .andExpect(jsonPath("$[0].servings").value(3))
                .andExpect(jsonPath("$[0].instructions").value("Anleitung1"))
                .andExpect(jsonPath("$[1].id").value(20))
                .andExpect(jsonPath("$[1].name").value("Pommes"))
                .andExpect(jsonPath("$[1].prepTime").value("10:20:30"))
                .andExpect(jsonPath("$[1].servings").value(6))
                .andExpect(jsonPath("$[1].instructions").value("Anleitung2"))
        ;

    }


    @Test
    @DisplayName("should validate create recipe request")
    void createRecipeWithInvalidateName() throws Exception {

        String recipeString = "{\"name\": \"x\",\"prepTime\": \"01:02:03\",\"servings\": 3}";

        mockMvc.perform(
                        post("/api/v1/recipes")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(recipeString)
                                .characterEncoding("utf-8")
                )
                // then
                .andExpect(status().isBadRequest());
    }
}



