package pe.edu.cibertec.DAWI_PILLCO_PORLLES_DAVID.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;

    private String title;

    private String description;

    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;


    private Integer rentalDuration;

    private Double rentalRate;

    private Integer length;

    private Double replacementCost;

    private String rating;

    private String specialFeatures;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdate;

    @OneToMany(mappedBy = "film", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
    private List<FilmActor> filmActors;

    @OneToMany(mappedBy = "film", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
    private List<FilmCategory> filmCategories;

    @OneToMany(mappedBy = "film", cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
    private List<Inventory> inventories;

}
