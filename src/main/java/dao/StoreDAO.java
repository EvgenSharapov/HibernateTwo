package dao;

import entity.address.City;
import entity.store.Store;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class StoreDAO extends GenericDao<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }

    public City getByName(String name) {
        Query<City>query = getCurrentSession().createQuery("select c from City c where c.city = :NAME", City.class);
        query.setParameter("NAME",name);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
