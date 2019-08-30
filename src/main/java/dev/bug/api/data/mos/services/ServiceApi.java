package dev.bug.api.data.mos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@PropertySource({"classpath:api.yml"})
public class ServiceApi {

    @Value("${scheme}")
    private String scheme;

    @Value("${host}")
    private String host;

    @Value("${confidential-key}")
    private String confidentialKey;

    private RestTemplate template;

    @Autowired
    public ServiceApi(RestTemplate template) {
        this.template = template;
    }

    public <T> T[] getItems(Class<T[]> type, Resource resource) {
        final UriComponents uri = UriComponentsBuilder
                .newInstance()
                .scheme(scheme)
                .host(host)
                .path(resource.getPath())
                .queryParam("api_key", confidentialKey)
                .build();

        final ResponseEntity<T[]> response = template.exchange(uri.toUriString(), HttpMethod.GET, null, type);
        return response.getBody();
    }
}
