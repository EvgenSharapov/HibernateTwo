package entity.staff;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.sql.Blob;
import java.util.Date;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="staff",schema = "movie")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name",length = 45,nullable=false)
    private String firstName;
    @Column(name="last_name",length = 45,nullable=false)
    private String lastName;
    @Column(name="address_id",nullable=false)
    private Integer addressId;
    @Column(name="store_id",nullable=false)
    private Integer storeId;
    @Column(name = "picture", columnDefinition = NULL)
    private Blob picture;
    @Column(name="email",length = 50,columnDefinition = NULL)
    private String email;
    @Column(name="active",nullable=false,columnDefinition = "1")
    private Integer active;
    @Column(name="username",length = 16,nullable=false)
    private String username;
    @Column(name="password",length = 40,columnDefinition = NULL)
    private String password;
    @Column(name="last_update",nullable=false,columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date lastUpdate;


}
