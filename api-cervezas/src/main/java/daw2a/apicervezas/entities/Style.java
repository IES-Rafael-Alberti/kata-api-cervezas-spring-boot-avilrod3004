package daw2a.apicervezas.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "styles")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cat_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "style_name")
    private String styleName;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;
}
