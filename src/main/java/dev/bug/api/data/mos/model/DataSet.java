package dev.bug.api.data.mos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataSetId;

    private int versionNumber;

    private int releaseNumber;

    private String caption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    private LocalDate publishDate;

    private String fullDescription;

    private String keywords;

    private boolean containsGeoData;

    private boolean containsAccEnvData;

    private boolean isForeign;

    private boolean isSeasonal;

    private String season;

    private boolean isArchive;

    private boolean isNew;

    private LocalDate lastUpdateDate;

    private String sefUrl;

    private String identificationNumber;
}