package dev.bug.api.data.mos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NonNull
    @Size(min = 2, max = 50)
    private String name;

    private String description;

    private String englishDescription;

    private Set<DataSet> dataSets;

    private Set<Integer> services;
}