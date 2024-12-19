package dao;

import entity.film.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends GenericDao<Category>{
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
