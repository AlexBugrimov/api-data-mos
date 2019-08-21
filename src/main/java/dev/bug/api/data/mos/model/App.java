package dev.bug.api.data.mos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption;

    private String description;

    @ManyToOne
    @JoinColumn
    private Category category;

    private LocalDate publishDate;

    private String developer;
}
