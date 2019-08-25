package dev.bug.api.data.mos.repositories;

import dev.bug.api.data.mos.model.Category;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TestEntityManager entityManager;

    private Category category;

    @Before
    public void setUp() {
        category = Category.builder()
                .name("Категория")
                .description("Описание")
                .englishName("Category")
                .englishDescription("Description").build();
    }

    @Test
    public void isSavedCategoriesInRepository() {
        final Category savedInDb = entityManager.persist(category);
        final Optional<Category> getFromBd = categoryRepository.findById(savedInDb.getCategoryId());
        assertThat(getFromBd.isPresent())
                .isTrue();
        assertThat(getFromBd.get())
                .isEqualTo(savedInDb);
    }

    @Test
    public void moreThanOneCategoryRemain() {
        final Category twoCategory = Category.builder()
                .name("Категория 2")
                .description("Описание")
                .englishName("Category")
                .englishDescription("Description").build();

        entityManager.persistAndFlush(category);
        entityManager.persistAndFlush(twoCategory);
        final long countCategory = categoryRepository.count();
        assertThat(countCategory)
                .isGreaterThan(1L);
    }

    @Test
    public void findAllCategory() {
        entityManager.persistAndFlush(category);
        final Iterable<Category> categories = categoryRepository.findAll();
        assertThat(categories)
                .isNotEmpty();
    }
}