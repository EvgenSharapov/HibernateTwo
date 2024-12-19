package dao;

import entity.rental.Rental;
import org.hibernate.SessionFactory;

public class RentalDAO extends GenericDao<Rental>{
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
}
