package entity.rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static org.hibernate.sql.InFragment.NULL;

@Getter
@Setter
@Entity
@Table(name="payment",schema = "movie")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="customer_id",nullable=false)
    private Integer customerId;
    @Column(name="staff_id",nullable=false)
    private Integer staffId;
    @Column(name="rental_id",columnDefinition = NULL)
    private Integer rentalId;
    @Column(name="amount",nullable=false)
    private Integer amount;
    @Column(name="payment_date",nullable=false)
    private Date paymentDate;
    @Column(name="last_update",nullable=false,columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date lastUpdate;

}
