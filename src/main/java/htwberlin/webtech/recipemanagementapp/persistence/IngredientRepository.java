package htwberlin.webtech.recipemanagementapp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

    List<IngredientEntity> findIngredientEntitiesByVegetarian(boolean vegetarian);

    List<IngredientEntity> findByVegan(boolean vegan);

    Optional<IngredientEntity> findFirstByName(String name);
}
