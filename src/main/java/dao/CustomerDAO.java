package dao;

import entity.rental.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAO extends GenericDao<Customer>{
    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
