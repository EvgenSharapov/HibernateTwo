package entity.address;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name="city",schema = "movie")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Short id;

    @Column(name="city",length = 50,nullable=false)
    private String address;

    @ManyToOne
    @JoinColumn(name="country_id",nullable=false)
    private Country country;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

}
