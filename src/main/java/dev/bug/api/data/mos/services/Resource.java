package dev.bug.api.data.mos.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Resource {

    APPS("apps"),
    CATEGORIES("categories"),
    DATA_SETS("dataset"),
    DEPARTMENTS("departments");

    private String path;
}
