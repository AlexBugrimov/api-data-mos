package dev.bug.api.data.mos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "category")
public class Category extends BaseEntity {

    @NonNull
    @Size(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @Column(name = "english_name")
    private String englishName;

    @Column(name = "description")
    private String description;

    @Column(name = "english_description")
    private String englishDescription;

    @Column(name = "icon")
    private Byte[] icon;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<App> apps;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<DataSet> dataSets;
}