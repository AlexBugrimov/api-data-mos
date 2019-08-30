package dev.bug.api.data.mos.services;

import org.springframework.beans.factory.annotation.Autowired;
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

    private final RestTemplate template;
    @Value("${api_key}")
    private String apiKey;

    @Autowired
    public ServiceApi(RestTemplate template) {
        this.template = template;
    }

    public <T> T[] getItems(final Class<T[]> type, final Resource resource) {
        return template.exchange(UriComponentsBuilder
                        .newInstance()
                        .scheme(scheme)
                        .host(host)
                        .path(resource.getPath())
                        .queryParam("api_key", apiKey)
                        .build().toUriString(),
                HttpMethod.GET, null, type).getBody();
    }
}
