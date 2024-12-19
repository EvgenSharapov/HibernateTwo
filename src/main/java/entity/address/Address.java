package entity.address;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name="address",schema = "movie")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Short id;

    @Column(name="address",length = 50,nullable=false)
    private String address;

    @Column(name="address2",length = 50)
    private String address2;

    @Column(name="district",length = 20,nullable=false)
    private String district;

    @ManyToOne
    @JoinColumn(name="city_id",nullable=false)
    private City city;

    @Column(name="postal_code",length = 10)
    private String postalCode;

    @Column(name="phone",length = 20,nullable=false)
    private String phone;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


}
