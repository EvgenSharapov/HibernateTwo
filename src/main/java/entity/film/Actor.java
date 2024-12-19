package entity.film;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="actor",schema = "movie")
public class Actor {
    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name="first_name",length = 45,nullable=false)
    private String firstName;

    @Column(name="last_name",length = 45,nullable=false)
    private String lastName;

    @Column(name="last_update",nullable=false)
    private Date lastUpdate;

    @ManyToMany
    @JoinTable(name = "film_actor",
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            joinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))

    private Set<Film> films;

}
