package htwberlin.webtech.recipemanagementapp.service;


import htwberlin.webtech.recipemanagementapp.persistence.IngredientRepository;
import htwberlin.webtech.recipemanagementapp.persistence.RecipeIngredientRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class IngredientServiceTest implements WithAssertions {

    @Mock
    private IngredientRepository repository;

    @InjectMocks
    private IngredientService ingredientService;

    @Test
    @DisplayName("should return false if ingredient doesnt exist")
    void testIngredientDeletionWithWrongIngredientId() {

        Long ingredientId = 1L;
        doReturn(false).when(repository).existsById(ingredientId);

        boolean result = ingredientService.deleteIngredient(ingredientId);

        verifyNoMoreInteractions(repository);
        assertThat(result).isFalse();
    }


}
