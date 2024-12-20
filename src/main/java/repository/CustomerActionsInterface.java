package repository;

import entity.rental.Customer;

public interface CustomerActionsInterface {
    void rentalFilm(Customer customer);
    void customerReturnInventoryToStore();
    Customer createCustomer();
}
