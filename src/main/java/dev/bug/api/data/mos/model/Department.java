package dev.bug.api.data.mos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "department")
public class Department extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "website_url")
    private String websiteUrl;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "english_description")
    private String englishDescription;

    @Column(name = "inn")
    private String inn;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<DataSet> dataSets;
}
