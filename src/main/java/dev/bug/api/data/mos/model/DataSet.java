package dev.bug.api.data.mos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class DataSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private int versionNumber;

    private int releaseNumber;

    private String caption;

    private long categoryId;

    private long departmentId;

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