package dev.bug.api.data.mos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryRest {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("EnglishName")
    private String englishName;

    @JsonProperty("EnglishDescription")
    private String englishDescription;

    @JsonProperty("Datasets")
    private Long[] dataSets;

    @JsonProperty("Services")
    private Long[] services;
}
