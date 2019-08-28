package dev.bug.api.data.mos.services.app;

import dev.bug.api.data.mos.model.AppItem;
import dev.bug.api.data.mos.model.AppItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class AppExchangeClient {

    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.key}")
    private String apiKey;

    private RestTemplate template;

    @Autowired
    public AppExchangeClient(RestTemplate template) {
        this.template = template;
    }

    public List<AppItem> getAppItems() {
        final UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(apiUrl)
                .path("apps")
                .queryParam("api_key", apiKey)
                .build();
        final ResponseEntity<AppItems> response = template.getForEntity(uri.toUriString(), AppItems.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return Objects.requireNonNull(response.getBody()).getItems();
        }
        return Collections.emptyList();
    }
}
