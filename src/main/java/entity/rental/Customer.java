package entity.rental;

import entity.address.Address;
import entity.store.Store;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="customer",schema = "movie")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Short id;

    @ManyToOne
    @JoinColumn(name="store_id",nullable=false)
    private Store store;

    @OneToOne
    @JoinColumn(name="address_id",nullable=false)
    private Address address;

    @Column(name="first_name",length = 45,nullable=false)
    private String firstName;

    @Column(name="last_name",length = 45,nullable=false)
    private String lastName;

    @Column(name="email",length = 50,columnDefinition = NULL)
    private String email;

    @Column(name="active",nullable=false,columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isActive;

    @Column(name="create_date",nullable=false)
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
