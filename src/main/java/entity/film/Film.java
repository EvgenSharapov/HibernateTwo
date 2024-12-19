package entity.film;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;


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

    @Convert(converter = YearAttributeConverter.class)
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
    @Convert(converter = RatingConverter.class)
    @Column(name="rating",columnDefinition = "enum('G', 'PG', 'PG-13', 'R', 'NC-17')")
    private Rating rating;



    @Column(name="special_features",nullable=false,columnDefinition = "set('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String specialFeatures;

    @ManyToMany
    @JoinTable(name = "film_actor",joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor>actors;

    @ManyToMany
    @JoinTable(name = "film_category",joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category>categories;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


    public Set<SpecialFeatures> getSpecialFeatures() {
        if(isNull(specialFeatures) || specialFeatures.isEmpty()){return null;}

        Set<SpecialFeatures>special=new HashSet<>();
        String[]splitResult = specialFeatures.split(",");
        for (String s : splitResult) {
            special.add(SpecialFeatures.getFeaturesByValue(s));
        }
        special.remove(null);
        return special;
    }

    public void setSpecialFeatures(Set<SpecialFeatures> specialFeatures) {
        if(isNull(specialFeatures)){this.specialFeatures = null;
        } else{
            this.specialFeatures = specialFeatures.stream().map(SpecialFeatures::getFeature).collect(Collectors.joining(","));
        }
    }
}
