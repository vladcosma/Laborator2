package Service;

import Domain.Movie;
import Repository.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private BaseRepository<Movie> movieRepository;

    public MovieService(BaseRepository<Movie> movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     *
     * @param id movie
     * @param title movie
     * @param year movie
     * @param ticketPrice movie
     * @param available movie
     */
    public void insert(Long id, String title, Integer year, Double ticketPrice, Boolean available) {
        Movie movie = new Movie(id, title, year, ticketPrice, available);
        movieRepository.add(movie);
    }

    /**
     *
     * @param id movie
     * @param title movie
     * @param year movie
     * @param ticketPrice movie
     * @param available movie
     */
    public void update(Long id, String title, Integer year, Double ticketPrice, Boolean available) {
        Movie movie = new Movie(id, title, year, ticketPrice, available);
        movieRepository.update(movie);
    }

    /**
     *
     * @param id for movie to remove
     */
    public void remove(Long id) {
        movieRepository.remove(id);
    }

    /**
     *
     * @param id for movie to find
     * @return movie
     */
    public Movie getById(Long id) {
        return movieRepository.findById(id);
    }

    /**
     *
     * @return list of movies
     */
    public List<Movie> getAll() {
        return movieRepository.getAll();
    }

    public List<Movie> fullTextSearch(String text) {
        List<Movie> results = new ArrayList<>();
        for (Movie movie : movieRepository.getAll()) {
            if (movie.getTitle().contains(text) ||
                    String.valueOf(movie.getYear()).equals(text)) {
                results.add(movie);
            }
        }
        return results;
    }
}
