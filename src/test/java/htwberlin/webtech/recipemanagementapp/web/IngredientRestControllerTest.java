package htwberlin.webtech.recipemanagementapp.web;

import htwberlin.webtech.recipemanagementapp.persistence.IngredientEntity;
import htwberlin.webtech.recipemanagementapp.service.IngredientService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(IngredientRestController.class)
class IngredientRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService ingredientService;

    @Test
    @DisplayName("should return 404 if ingredient is not found")
    void findNonExistingIngredient() throws Exception {

        doReturn(null).when(ingredientService).findById(1L);

        this.mockMvc.perform(get("/api/v1/ingredients/1"))
                // then
                .andExpect(status().isNotFound());
    }


    @Test
    @DisplayName("should return all ingredients in json format")
    void findAllIngredients() throws Exception {


        var ingredientEntities = List.of(
                new IngredientEntity(1L,"A",true, true),
                new IngredientEntity(2L,"B",true, false)
        );

        doReturn(ingredientEntities).when(ingredientService).findAll();

        // when
        mockMvc.perform(get("/api/v1/ingredients"))
                // then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("A"))
                .andExpect(jsonPath("$[0].vegetarian").value(true))
                .andExpect(jsonPath("$[0].vegan").value(true))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("B"))
                .andExpect(jsonPath("$[1].vegetarian").value(true))
                .andExpect(jsonPath("$[1].vegan").value(false));
    }


    @Test
    @DisplayName("should validate create ingredient request")
    void createIngredientWithInvalidateName() throws Exception {

        String ingredientString = "{\"name\": \"x\",\"vegetarian\": true,\"vegan\": true}";

        mockMvc.perform(
                        post("/api/v1/ingredients")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(ingredientString)
                                .characterEncoding("utf-8")
                )
                // then
                .andExpect(status().isBadRequest());
    }
}
