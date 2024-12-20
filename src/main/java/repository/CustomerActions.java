package repository;

import dao.*;
import entity.address.Address;
import entity.address.City;
import entity.film.Film;
import entity.rental.Customer;
import entity.rental.Inventory;
import entity.rental.Payment;
import entity.rental.Rental;
import entity.staff.Staff;
import entity.store.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomerActions implements CustomerActionsInterface{
SessionFactory sessionFactory = RepositoryConnections.getInstance().getSessionFactory();
FilmDAO filmDAO = RepositoryConnections.getInstance().getFilmDAO();
StoreDAO storeDAO = RepositoryConnections.getInstance().getStoreDAO();
InventoryDAO inventoryDAO = RepositoryConnections.getInstance().getInventoryDAO();
RentalDAO rentalDAO = RepositoryConnections.getInstance().getRentalDAO();
PaymentDAO paymentDAO = RepositoryConnections.getInstance().getPaymentDAO();
AddressDAO addressDAO = RepositoryConnections.getInstance().getAddressDAO();
CustomerDAO customerDAO = RepositoryConnections.getInstance().getCustomerDAO();

    @Override
    public void rentalFilm(Customer customer) {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Film film = filmDAO.getFirstAvailableFilmForRent();
            Store store = storeDAO.getItems(0,1).getFirst();

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setCustomer(customer);
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rentalDAO.save(rental);

            Payment payment = new Payment();
            payment.setRental(rental);
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setAmount(BigDecimal.valueOf(66));
            paymentDAO.save(payment);

            session.getTransaction().commit();}
    }

    @Override
    public void customerReturnInventoryToStore() {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();

            Rental rental = rentalDAO.getAnyUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());

            rentalDAO.save(rental);

            session.getTransaction().commit();}

    }

    @Override
    public Customer createCustomer() {
        try(Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            Store store = storeDAO.getItems(0,1).getFirst();
            City city = storeDAO.getByName("Ambattur");

            Address address = new Address();
            address.setCity(city);
            address.setAddress("Адрес11");
            address.setDistrict("Дистинкт11");
            address.setPhone("900-900-900-900");
            addressDAO.save(address);

            Customer customer = new Customer();
            customer.setAddress(address);
            customer.setEmail("gogo123@mail.ru");
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
