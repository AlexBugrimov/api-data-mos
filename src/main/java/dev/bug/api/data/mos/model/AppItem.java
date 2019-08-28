package dev.bug.api.data.mos.model;

import lombok.Data;

@Data
public class AppItem {

    private String id;
    private String caption;
    private String description;
    private String categoryId;
    private String publishDate;
    private String developer;
}
