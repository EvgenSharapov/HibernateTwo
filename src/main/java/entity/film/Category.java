package entity.film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="category",schema = "movie")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name="name",length = 25,nullable=false)
    private String name;

    @ManyToMany
    @JoinTable(name = "film_category",
            inverseJoinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))

    private Set<Film> films;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
