package tn.crudtp1.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.crudtp1.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
