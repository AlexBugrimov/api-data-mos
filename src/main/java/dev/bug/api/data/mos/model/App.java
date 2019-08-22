package dev.bug.api.data.mos.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "app")
public class App extends BaseEntity {

    @Column(name = "caption")
    private String caption;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "developer")
    private String developer;
}
