package entity;

import entity.film.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="film_text",schema = "movie")
public class FilmText {
    @Id
    @Column(name = "film_id")
    private Short id;

    @Column(name="title",nullable=false)
    private String title;

    @Column(name="description",columnDefinition = "text")
    @Type(type = "text")
    private String description;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;
}
