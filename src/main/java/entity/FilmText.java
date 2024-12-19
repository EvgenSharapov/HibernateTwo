package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="film_text",schema = "movie")
public class FilmText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title",nullable=false)
    private String title;
    @Column(name="description",columnDefinition = NULL)
    private String description;
}
