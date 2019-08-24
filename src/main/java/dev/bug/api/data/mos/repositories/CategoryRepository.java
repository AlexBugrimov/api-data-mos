package dev.bug.api.data.mos.repositories;

import dev.bug.api.data.mos.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category findByCategoryId(Long categoryId);
}
