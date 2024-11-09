package daw2a.apicervezas.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "beers")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "brewery_id", referencedColumnName = "id")
    private Brewery brewery;

    private String name;

    @Column(name = "cat_id")
    private Long catId;

    @Column(name = "style_id")
    private Long styleId;

    private Float abv;
    private Float ibu;
    private Float srm;
    private Long upc;
    private String filepath;

    @NotNull
    private String descript;

    @Column(name = "add_user")
    private Long addUser;

    @Column(name = "last_mod")
    private LocalDateTime lastMod;

}

