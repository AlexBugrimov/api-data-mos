package dev.bug.api.data.mos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "dataSets")
@Accessors(chain = true)
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String websiteUrl;

    private String shortName;

    private String englishName;

    private String englishDescription;

    private String inn;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<DataSet> dataSets;
}
