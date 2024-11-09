package daw2a.apicervezas.repositories;

import daw2a.apicervezas.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
