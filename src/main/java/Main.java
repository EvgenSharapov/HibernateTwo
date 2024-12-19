import dao.*;
import entity.address.*;
import entity.film.*;
import entity.other.FilmText;
import entity.rental.*;
import entity.staff.Staff;
import entity.store.Store;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.time.LocalDateTime;
import java.util.Properties;
@Getter
@Setter
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

    public Main() {

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

        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);

    }

    public static void main(String[] args) {
        Main main = new Main();
        Customer customer = main.createCustomer();
        main.customerReturnInventoryToStore();
    }




    private void customerReturnInventoryToStore() {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Rental rental = rentalDAO.getAnyUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());

            rentalDAO.save(rental);

            session.getTransaction().commit();}
    }

    private Customer createCustomer() {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Store store = storeDAO.getItems(0,1).getFirst();
            City city = storeDAO.getByName("Ambattur");

            Address address = new Address();
            address.setCity(city);
            address.setAddress("Адрес1");
            address.setDistrict("Дистинкт1");
            address.setPhone("900-900-900-900");
            addressDAO.save(address);

            Customer customer = new Customer();
            customer.setAddress(address);
            customer.setEmail("gogo12@mail.ru");
            customer.setStore(store);
            customer.setFirstName("Иван");
            customer.setLastName("Иванов");
            customer.setIsActive(true);
            customerDAO.save(customer);

            session.getTransaction().commit();
            return customer;
        }

    }
}