package dev.bug.api.data.mos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"apps", "dataSets"})
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 2, max = 50)
    private String name;

    private String englishName;

    private String description;

    private String englishDescription;

    private Byte[] icon;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<App> apps;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<DataSet> dataSets;
}