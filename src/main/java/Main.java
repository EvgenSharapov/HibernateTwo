import dao.*;
import entity.address.*;
import entity.film.*;
import entity.other.FilmText;
import entity.rental.*;
import entity.staff.Staff;
import entity.store.Store;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Main {
    private final SessionFactory sessionFactory;

    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CategoryDAO categoryDAO;
    private final FilmDAO filmDAO;
    private final LanguageDAO languageDAO;
    private final FilmTextDAO filmTextDAO;
    private final CustomerDAO customerDAO;
    private final InventoryDAO inventoryDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;

    public Main(ActorDAO actorDAO, AddressDAO addressDAO, CityDAO cityDAO, CountryDAO countryDAO, CategoryDAO categoryDAO, FilmDAO filmDAO, LanguageDAO languageDAO, FilmTextDAO filmTextDAO, CustomerDAO customerDAO, InventoryDAO inventoryDAO, PaymentDAO paymentDAO, RentalDAO rentalDAO, StaffDAO staffDAO, StoreDAO storeDAO) {
        this.actorDAO = actorDAO;
        this.addressDAO = addressDAO;
        this.cityDAO = cityDAO;
        this.countryDAO = countryDAO;
        this.categoryDAO = categoryDAO;
        this.filmDAO = filmDAO;
        this.languageDAO = languageDAO;
        this.filmTextDAO = filmTextDAO;
        this.customerDAO = customerDAO;
        this.inventoryDAO = inventoryDAO;
        this.paymentDAO = paymentDAO;
        this.rentalDAO = rentalDAO;
        this.staffDAO = staffDAO;
        this.storeDAO = storeDAO;
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3305/movie");
       // properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
       // properties.put(Environment.URL, "jdbc:mysql://localhost:3305/movie");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "validate");

        this.sessionFactory = new Configuration()
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .addProperties(properties)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}