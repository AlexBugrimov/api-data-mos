package dev.bug.api.data.mos.services.category;

import dev.bug.api.data.mos.exceptions.CategoryNotExistsException;
import dev.bug.api.data.mos.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryServiceRepositoryTest {

    @Autowired
    private CategoryService categoryService;

    private Category category;

    @Before
    public void setUp() {
        category = Category
                .builder()
                .name("Название категории")
                .englishName("Category name")
                .description("Описание категории")
                .englishDescription("Description")
                .build();
    }

    @Test
    public void getAllCategories() {
        final Category oneCategory = categoryService.save(category);
        final Category twoCategory = categoryService.save(category);

        final List<Category> allCategories = categoryService.getAll();
        assertThat(allCategories)
                .contains(oneCategory, twoCategory);
    }

    @Test
    public void savingAndGetOfNewCategory() {
        final Category expectedCategory = categoryService.save(category);
        final Category actualCategory = categoryService.getOneById(expectedCategory.getCategoryId());
        assertThat(actualCategory)
                .isEqualTo(expectedCategory);
    }

    @Test
    public void updateForCategory() {
        final Category savedCategory = categoryService.save(category);
        final Category updatedCategory = Category
                .builder()
                .name("Обновление для категории")
                .build();
        final Category newCategory = categoryService.update(savedCategory.getCategoryId(), updatedCategory);
        assertThat(savedCategory.getCategoryId())
                .isEqualTo(newCategory.getCategoryId());
        assertThat(newCategory.getName())
                .isEqualTo("Обновление для категории");
    }

    @Test(expected = CategoryNotExistsException.class)
    public void savingAndDeletingOneCategory() {
        final Category savingCategory = categoryService.save(category);
        categoryService.delete(savingCategory.getCategoryId());
        categoryService.getOneById(savingCategory.getCategoryId());
    }
}