package entity.rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="customer",schema = "movie")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="store_id",nullable=false)
    private Integer cityId;
    @Column(name="address_id",nullable=false)
    private Integer addressId;
    @Column(name="first_name",length = 45,nullable=false)
    private String firstName;
    @Column(name="last_name",length = 45,nullable=false)
    private String lastName;
    @Column(name="email",length = 50,columnDefinition = NULL)
    private String email;
    @Column(name="active",nullable=false,columnDefinition = "1")
    private Integer active;
    @Column(name="create_date",nullable=false)
    private Date createDate;
    @Column(name="last_update",nullable=false,columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date lastUpdate;
}
