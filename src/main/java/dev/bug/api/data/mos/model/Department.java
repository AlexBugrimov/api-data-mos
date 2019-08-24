package dev.bug.api.data.mos.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<DataSet> dataSets = new HashSet<>();

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

    @Builder
    public Department(final String name,
                      final String description,
                      final String websiteUrl,
                      final String shortName,
                      final String englishName,
                      final String englishDescription,
                      final String inn) {
        this.name = name;
        this.description = description;
        this.websiteUrl = websiteUrl;
        this.shortName = shortName;
        this.englishName = englishName;
        this.englishDescription = englishDescription;
        this.inn = inn;
    }
}
