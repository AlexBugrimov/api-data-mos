package dev.bug.api.data.mos.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "icon")
    private Byte[] icon = new Byte[0];

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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<App> apps = new HashSet<>();

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Set<DataSet> dataSets = new HashSet<>();

    @Builder
    public Category(@NonNull @Size(min = 2, max = 50) final String name,
                    final String englishName,
                    final String description,
                    final String englishDescription) {
        this.name = name;
        this.englishName = englishName;
        this.description = description;
        this.englishDescription = englishDescription;
    }
}