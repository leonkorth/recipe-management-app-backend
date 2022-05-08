package htwberlin.webtech.recipemanagementapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    List<IngredientEntity> findIngredientEntitiesByVegetarian(boolean vegetarian);

    List<IngredientEntity> findIngredientEntitiesByVegan(boolean vegan);
}
