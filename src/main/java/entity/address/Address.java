package entity.address;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Entity
@Table(name="address",schema = "movie")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="address",length = 50,nullable=false)
    private String address;
    @Column(name="address2",length = 50)
    private String address2;
    @Column(name="district",length = 20,nullable=false)
    private String district;
    @Column(name="city_id")
    private Integer cityId;
    @Column(name="postal_code",length = 10)
    private String postalCode;
    @Column(name="phone",length = 20,nullable=false)
    private String phone;
    @Column(name="last_update",nullable=false)
    private Date lastUpdate;


}
