package dev.bug.api.data.mos.services.app;

import dev.bug.api.data.mos.exceptions.AppNotExistsException;
import dev.bug.api.data.mos.model.App;
import dev.bug.api.data.mos.model.Category;
import dev.bug.api.data.mos.repositories.CategoryRepository;
import org.hibernate.Hibernate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private AppService appService;
    private App app;

    @Before
    public void setUp() {
        final Category category = Category
                .builder()
                .name("Категория")
                .englishName("Category")
                .description("Описание категории")
                .englishDescription("Description")
                .build();
        categoryRepository.save(category);
        app = App
                .builder()
                .caption("Caption")
                .publishDate(LocalDate.now())
                .developer("Mos Dev")
                .description("Description")
                .category(category)
                .build();
    }

    @Test
    public void addedAppInRepository() {
        final App expectedApp = appService.save(this.app);
        final App actualApp = appService.getOneById(expectedApp.getAppId());
        assertThat(actualApp).isEqualToIgnoringGivenFields(expectedApp, "category");
    }

    @Test
    public void cleaningOfRepositoryOfApp() {
        appService.clean();
        final List<App> apps = appService.getAll();
        assertThat(apps)
                .isEmpty();
    }

    @Test
    public void getAllAppOfRepository() {
        appService.save(app);
        final List<App> apps = appService.getAll();
        assertThat(apps)
                .isNotEmpty();
    }

    @Test(expected = AppNotExistsException.class)
    public void deleteApp() {
        final App deletedApp = appService.save(app);
        appService.delete(deletedApp.getAppId());
        appService.getOneById(deletedApp.getAppId());
    }

    @Test
    public void updateApp() {
        final App savedApp = appService.save(app);
        final Long appId = savedApp.getAppId();
        final App updatedApp = App
                .builder()
                .category(savedApp.getCategory())
                .description("Новое описание приложения")
                .developer("Dev Bug")
                .publishDate(LocalDate.now())
                .caption("Новый заголовок")
                .build();
        final App expectedApp = appService.update(appId, updatedApp);
        Hibernate.initialize(expectedApp.getCategory());
        assertThat(updatedApp)
                .isEqualToIgnoringGivenFields(expectedApp, "appId");
    }
}