package edu.utd.movierental;

import edu.utd.movierental.factory.MovieRentalFactory;
import edu.utd.movierental.models.*;
import edu.utd.movierental.models.*;
import edu.utd.movierental.utils.RentalType;

import javax.xml.bind.*;
import java.io.StringWriter;

public class MovieRentalApplication {

    public static void main(String[] args) throws JAXBException {
        Customer customer = new Customer("Vamsi Krishna Somepalli");
        Transaction transaction = new Transaction(customer);
        customer.addRental(new Rental(new Movie("Toy Story"), 1, RentalType.CHILDREN_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Star Wars"), 2, RentalType.NEW_MOVIE_RENTAL));
        customer.addRental(new Rental(new Movie("Mission Impossible"), 4, RentalType.REGULAR_MOVIE_RENTAL));
        transaction.computeRentalPoints();
        System.out.println(customer.getStatement().printStatementAsXML());
    }

}
