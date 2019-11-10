package edu.utd.movierental.models;

import edu.utd.movierental.factory.FrequentRentalStrategyFactory;
import edu.utd.movierental.strategy.DefaultFrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.FrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.PricingStrategy;
import edu.utd.movierental.strategy.RegularMoviePricingStrategy;
import edu.utd.movierental.utils.RentalType;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rental {
    private Movie movie;
    private int daysRented;
    private int rentalPoints = 0;
    private Customer customer;
    private RentalType rentalType;
    private  PricingStrategy pricingStrategy;
    private FrequentRentalPointsStrategy frequentRentalPointsStrategy;
    
    public Rental(Movie movie, int daysRented, RentalType rentalType) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.customer = customer;
        this.rentalType = rentalType;
        this.pricingStrategy =  new RegularMoviePricingStrategy();
        this.frequentRentalPointsStrategy = new DefaultFrequentRentalPointsStrategy();
    }

    public Rental(Movie movie, int daysRented, PricingStrategy pricingStrategy, FrequentRentalPointsStrategy frequentRentalPointsStrategy) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.pricingStrategy =  pricingStrategy;
        this.frequentRentalPointsStrategy = frequentRentalPointsStrategy;
    }

    public int getDaysRented() {
        return daysRented;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public RentalType getRentalType() {
    	return rentalType;
    }

    public double computeRentalPrice() {
        return this.pricingStrategy.computeRentalPrice(this);
    };

    public int computeRentalPoints(int frequentRenterPoints) {
        return FrequentRentalStrategyFactory.getStrategy(this).computeRentalPoints(frequentRenterPoints, this);
    }
}