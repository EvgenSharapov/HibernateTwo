package entity.address;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="city",schema = "movie")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="city",length = 50,nullable=false)
    private String address;
    @Column(name="country_id",nullable=false)
    private Integer countryId;
    @Column(name="last_update",nullable=false)
    private Date lastUpdate;

}
