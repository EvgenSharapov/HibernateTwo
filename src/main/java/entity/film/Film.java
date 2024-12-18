package entity.film;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="film",schema = "movie")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title",length = 128,nullable=false)
    private String title;
    @Column(name="description",columnDefinition = NULL)
    private String description;
    @Column(name="release_year",columnDefinition = NULL)
    private Date releaseYear;
    @Column(name="language_id",nullable=false)
    private Integer languageId;
    @Column(name="original_language_id",columnDefinition = NULL)
    private Integer originalLanguageId;
    @Column(name="rental_duration",nullable=false,columnDefinition = "3")
    private Integer rentalDuration;
    @Column(name="rental_rate",nullable=false,columnDefinition = "4.99")
    private Integer rentalRate;
    @Column(name="length",columnDefinition = NULL)
    private Integer length;
    @Column(name="replacement_cost",nullable=false)
    private Integer replacementCost;
    @Enumerated(EnumType.STRING)
    @Column(name="rating",columnDefinition = "G")
    private Rating rating;
    @Column(name="special_features",nullable=false)////////////////
    private String specialFeatures;/////////////////
    @Column(name="last_update",nullable=false)
    private Date lastUpdate;
}
