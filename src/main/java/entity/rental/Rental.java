package entity.rental;

import entity.staff.Staff;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="rental",schema = "movie")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Integer id;

    @Column(name="rental_date",nullable=false)
    private LocalDateTime rentalDate;

    @ManyToOne
    @JoinColumn(name="inventory_id",nullable=false)
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name="customer_id",nullable=false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="staff_id",nullable=false)
    private Staff staff;

    @Column(name="return_date",columnDefinition = NULL)
    private LocalDateTime returnDate;

    @Column(name="last_update",nullable=false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
}
