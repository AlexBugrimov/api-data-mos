package dev.bug.api.data.mos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Size(min = 2, max = 50)
    private String name;

    private String englishName;

    private String description;

    private String englishDescription;

    private Byte[] icon = new Byte[0];

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<App> apps = new HashSet<>();

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<DataSet> dataSets = new HashSet<>();
}