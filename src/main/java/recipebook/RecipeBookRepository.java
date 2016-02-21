package recipebook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface RecipeBookRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByType(String type);
}
