package htwberlin.webtech.recipemanagementapp.service;

import htwberlin.webtech.recipemanagementapp.persistence.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @MockBean
    private RecipeIngredientRepository recipeIngredientRepository;

    @Test
    @DisplayName("should find recipe by ingredient id")
    void testGetRecipesByIngredientId(){


        var r1 = new RecipeEntity(10L, "r1", LocalTime.of(1,10),3,"text");
        var r2 = new RecipeEntity(11L, "r2", LocalTime.of(1,10),3,"text");

        var i1 = new IngredientEntity(1L,"i1",true,true);
        var i2 = new IngredientEntity(2L,"i2",true,true);

        var ri1pk = new RecipeIngredientPK(10L,1L);
        var ri1 = new RecipeIngredientEntity(ri1pk,r1,i1,2L,"Anzahl");

        var ri2pk = new RecipeIngredientPK(11L,2L);
        var ri2 = new RecipeIngredientEntity(ri2pk,r2,i2,2L,"Anzahl");

        doReturn(List.of(ri1,ri2)).when(recipeIngredientRepository).findAll();

        List<RecipeEntity> actualRecipes = recipeService.findRecipeByIngredient(1L);
        List<RecipeEntity> expectedRecipes = List.of(r1);

        assertEquals(actualRecipes,expectedRecipes);
    }


}
