
import entity.rental.Customer;
import repository.CustomerActions;
import repository.FilmActions;
import repository.RepositoryConnections;



public class Main {



    public static void main(String[] args) {
        RepositoryConnections repositoryConnections = RepositoryConnections.getInstance();
        FilmActions filmActions = new FilmActions();
        filmActions.newFilmAddInStore();
        CustomerActions customerActions = new CustomerActions();
        Customer customer = customerActions.createCustomer();
        customerActions.customerReturnInventoryToStore();
        customerActions.rentalFilm(customer);

    }
}
