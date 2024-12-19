package dao;

import entity.address.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends GenericDao<Country>{
    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
