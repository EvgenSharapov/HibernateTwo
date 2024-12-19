package entity.staff;


import entity.address.Address;
import entity.store.Store;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="staff",schema = "movie")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Byte id;

    @Column(name="first_name",length = 45,nullable=false)
    private String firstName;

    @Column(name="last_name",length = 45,nullable=false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name="address_id",nullable=false)
    private Address address;

    @ManyToOne
    @JoinColumn(name="store_id",nullable=false)
    private Store store;

    @Lob
    @Column(name = "picture", columnDefinition = "BLOB")
    private byte[] picture;

    @Column(name="email",length = 50)
    private String email;

    @Column(name="active",nullable=false,columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isActive;

    @Column(name="username",length = 16,nullable=false)
    private String username;

    @Column(name="password",length = 40)
    private String password;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


}
