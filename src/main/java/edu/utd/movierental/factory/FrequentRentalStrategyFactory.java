package edu.utd.movierental.factory;

import edu.utd.movierental.models.Movie;
import edu.utd.movierental.models.Rental;
import edu.utd.movierental.strategy.ChildrenMoviePricingStrategy;
import edu.utd.movierental.strategy.DefaultFrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.FrequentRentalPointsStrategy;
import edu.utd.movierental.strategy.NewMoviePricingStrategy;
import edu.utd.movierental.strategy.NewReleaseFrequentRentalPointsStrategy;
import edu.utd.movierental.utils.RentalType;

public class FrequentRentalStrategyFactory {
		public static FrequentRentalPointsStrategy getStrategy(Rental rental){
			FrequentRentalPointsStrategy frequentRentalPointsStrategy = null;

	        switch (rental.getRentalType()) {
	            case REGULAR_MOVIE_RENTAL:
	            	frequentRentalPointsStrategy = new DefaultFrequentRentalPointsStrategy();
	                break;
	            case CHILDREN_MOVIE_RENTAL:
	            	frequentRentalPointsStrategy = new DefaultFrequentRentalPointsStrategy();
	                break;
	            case NEW_MOVIE_RENTAL:
	            	frequentRentalPointsStrategy = new NewReleaseFrequentRentalPointsStrategy();
	                break;
	            default:
	            	frequentRentalPointsStrategy = new DefaultFrequentRentalPointsStrategy();
	                break;
	        }
	        return frequentRentalPointsStrategy;
	    }

}
