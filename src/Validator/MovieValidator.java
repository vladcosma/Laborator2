package Validator;

import Domain.Movie;
import Exception.InvalidPriceException;

public class MovieValidator implements Validator<Movie> {

    public void validate(Movie movie) {
        if (movie.getTicketPrice() <= 0) {
            throw new InvalidPriceException("The ticket price must be greater than 0!");
        }
    }
}