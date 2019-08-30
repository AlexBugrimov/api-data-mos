package dev.bug.api.data.mos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DepartmentRest {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("WebsiteUrl")
    private String websiteUrl;

    @JsonProperty("ShortName")
    private String shortName;

    @JsonProperty("EnglishName")
    private String englishName;

    @JsonProperty("EnglishDescription")
    private String englishDescription;

    @JsonProperty("Inn")
    private String inn;

    @JsonProperty("Datasets")
    private Long[] dataSets;
}
