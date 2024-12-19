package entity.rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="rental",schema = "movie")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="rental_date",nullable=false)
    private Date rentalDate;
    @Column(name="inventory_id",nullable=false)
    private Integer inventoryId;
    @Column(name="customer_id",nullable=false)
    private Integer customerId;
    @Column(name="staff_id",nullable=false)
    private Integer staffId;
    @Column(name="return_date",columnDefinition = NULL)
    private Date returnDate;
    @Column(name="last_update",nullable=false,columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date lastUpdate;
}
