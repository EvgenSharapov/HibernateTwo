package entity.film;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;
import java.util.Set;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="film",schema = "movie")
public class Film {
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name="title",length = 128,nullable=false)
    private String title;

    @Column(name="description",columnDefinition = "text")
    @Type(type="text")
    private String description;

    @Column(name="release_year",columnDefinition = "year")
    private Year releaseYear;

    @ManyToOne
    @JoinColumn(name="language_id",nullable=false)
    private Language languageId;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguageId;

    @Column(name="rental_duration",nullable=false)
    private Byte rentalDuration;

    @Column(name="rental_rate",nullable=false)
    private BigDecimal rentalRate;

    @Column(name="length")
    private Short length;

    @Column(name="replacement_cost",nullable=false)
    private BigDecimal replacementCost;

    @Enumerated(EnumType.STRING)
    @Column(name="rating",columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private Rating rating;

    @Column(name="special_features",nullable=false,columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
