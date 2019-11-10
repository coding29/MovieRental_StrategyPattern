package edu.utd.movierental.models;

public class Transaction {
    private  Customer customer;

    public Transaction (Customer customer) {
        this.customer = customer;
    }

    public int computeRentalPoints() {
        for (Rental rental :this.customer.getRentals()) {
            this.customer.setFrequentRenterPoints(rental.computeRentalPoints(this.customer.getFrequentRenterPoints()));
        }
        return 0;
    }

}
