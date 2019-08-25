package dev.bug.api.data.mos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    private String name;

    private String description;

    private String websiteUrl;

    private String shortName;

    private String englishName;

    private String englishDescription;

    private String inn;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<DataSet> dataSets = new HashSet<>();
}
