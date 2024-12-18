package entity.address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="country",schema = "movie")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="country",length = 50,nullable=false)
    private String country;
    @Column(name="last_update",nullable=false)
    private Date lastUpdate;


}
