package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="store",schema = "movie")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="manager_staff_id",nullable=false)
    private Integer managerStaffId;
    @Column(name="address_id",nullable=false)
    private Integer addressId;
    @Column(name="last_update",nullable=false,columnDefinition = "CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date lastUpdate;
}
