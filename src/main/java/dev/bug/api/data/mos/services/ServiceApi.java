package dev.bug.api.data.mos.services;

import dev.bug.api.data.mos.model.AppRest;
import dev.bug.api.data.mos.model.CategoryRest;
import dev.bug.api.data.mos.model.DepartmentRest;
import dev.bug.api.data.mos.services.app.AppService;
import dev.bug.api.data.mos.services.category.CategoryService;
import dev.bug.api.data.mos.services.dataSet.DataSetService;
import dev.bug.api.data.mos.services.department.DepartmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@PropertySource({"classpath:api.yml"})
public class ServiceApi {

    @Value("${scheme}")
    private String scheme;

    @Value("${host}")
    private String host;

    @Value("${api_key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final AppService appService;
    private final CategoryService categoryService;
    private final DataSetService dataSetService;
    private final DepartmentService departmentService;

    public ServiceApi(final RestTemplate restTemplate,
                      final AppService appService,
                      final CategoryService categoryService,
                      final DataSetService dataSetService,
                      final DepartmentService departmentService) {
        this.restTemplate = restTemplate;
        this.appService = appService;
        this.categoryService = categoryService;
        this.dataSetService = dataSetService;
        this.departmentService = departmentService;
    }

    private <T> T[] getItems(final Class<T[]> type, final Resource resource) {
        return restTemplate.exchange(UriComponentsBuilder
                        .newInstance()
                        .scheme(scheme)
                        .host(host)
                        .path(resource.getPath())
                        .queryParam("api_key", apiKey)
                        .build().toUriString(),
                HttpMethod.GET, null, type).getBody();
    }

    public void toUpdateData() {
        final CategoryRest[] categoryRests = getItems(CategoryRest[].class, Resource.CATEGORIES);
        final AppRest[] appRests = getItems(AppRest[].class, Resource.APPS);
        final DepartmentRest[] departmentRests = getItems(DepartmentRest[].class, Resource.DEPARTMENTS);
        System.out.println();
    }
}
