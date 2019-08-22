package dev.bug.api.data.mos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "data_set")
public class DataSet extends BaseEntity {

    @Column(name = "version_number")
    private int versionNumber;

    @Column(name = "release_number")
    private int releaseNumber;

    @Column(name = "caption")
    private String caption;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "keywords")
    private String keywords;

    @Column(name = "contains_geodata")
    private boolean containsGeoData;

    @Column(name = "contains_acc_env_data")
    private boolean containsAccEnvData;

    @Column(name = "is_foreign")
    private boolean isForeign;

    @Column(name = "is_seasonal")
    private boolean isSeasonal;

    @Column(name = "season")
    private String season;

    @Column(name = "is_archive")
    private boolean isArchive;

    @Column(name = "is_new")
    private boolean isNew;

    @Column(name = "last_update_date")
    private LocalDate lastUpdateDate;

    @Column(name = "sef_url")
    private String sefUrl;

    @Column(name = "identification_number")
    private String identificationNumber;
}