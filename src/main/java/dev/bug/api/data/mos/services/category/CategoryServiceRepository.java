package dev.bug.api.data.mos.services.category;

import dev.bug.api.data.mos.exceptions.CategoryAlreadyExistsException;
import dev.bug.api.data.mos.exceptions.CategoryNotExistsException;
import dev.bug.api.data.mos.model.Category;
import dev.bug.api.data.mos.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceRepository implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getOneById(Long id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(CategoryNotExistsException::new);
    }

    @Override
    public Category save(Category category) {
        final Category savedCategory = category.getCategoryId() == null
                ? category : getExistingCategory(category.getCategoryId());
        return categoryRepository.save(savedCategory);
    }

    @Override
    public Category update(Long id, Category newCategory) {
        final Category oldCategory = getExistingCategory(id);
        BeanUtils.copyProperties(newCategory, oldCategory, "categoryId");
        return categoryRepository.save(newCategory);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(getExistingCategory(id).getCategoryId());
    }

    @Override
    public void clean() {
        categoryRepository.deleteAll();
    }

    private Category getExistingCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(CategoryAlreadyExistsException::new);
    }
}
