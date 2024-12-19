package entity.film;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="language",schema = "movie")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;
    @Column(name="name",length = 20,nullable=false,columnDefinition="char")
    private String title;
    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
