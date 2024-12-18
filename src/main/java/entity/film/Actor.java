package entity.film;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="actor",schema = "movie")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name",length = 45,nullable=false)
    private String firstName;
    @Column(name="last_name",length = 45,nullable=false)
    private String lastName;
    @Column(name="last_update",nullable=false)
    private Date lastUpdate;

}
