package dev.bug.api.data.mos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AppRest {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Caption")
    private String caption;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("CategoryId")
    private String categoryId;

    @JsonProperty("PublishDate")
    private String publishDate;

    @JsonProperty("Developer")
    private String developer;
}
