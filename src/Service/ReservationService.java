package Service;

import Domain.ClientCard;
import Domain.Movie;
import Domain.Reservation;
import Exception.InvalidClientCardIdException;
import Exception.InvalidMovieIdException;
import Repository.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private BaseRepository<Reservation> reservationRepository;

    private BaseRepository<Movie> movieRepository;

    private BaseRepository<ClientCard> clientCardRepository;

    public ReservationService(BaseRepository<Reservation> reservationRepository, BaseRepository<Movie> movieRepository, BaseRepository<ClientCard> clientCardRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
        this.clientCardRepository = clientCardRepository;
    }

    private Double getPointsOnCard(Long idMovie, Long idClientCard) {
        Movie movie = movieRepository.findById(idMovie);
        Double basePrice = movie.getTicketPrice();
        if (idClientCard != 0) {
            return 10 / 100 * basePrice;
        } else {
            return 0.00;
        }
    }

    public Reservation insert(Long id, Long idMovie, Long idClientCard, String date, String time) {
        Movie movie = movieRepository.findById(idMovie);
        ClientCard clientCard = clientCardRepository.findById(idClientCard);
        if (!movie.isAvailable()) {
            throw new InvalidMovieIdException("This movie is not available!");
        }
        if (!idClientCard.equals(clientCard.getId())) {
            throw new InvalidClientCardIdException("This client doesn't exist!");
        }
        Double points = 0.00;
        points = getPointsOnCard(idMovie, idClientCard);
        clientCard.setPoints(points);
        System.out.println("Points on card: " + clientCard.getPoints());
        Reservation reservation = new Reservation(id, idMovie, idClientCard, date, time);
        return reservationRepository.add(reservation);
    }

    public Reservation update(Long id, Long idMovie, Long idClientCard, String date, String time) {
        Reservation reservation = new Reservation(id, idMovie, idClientCard, date, time);
        return reservationRepository.update(reservation);
    }

    public void remove(Long id) {
        reservationRepository.remove(id);
    }

    public Reservation getById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public List<Reservation> fullTextSearch(String text) {
        List<Reservation> results = new ArrayList<>();
        for (Reservation reservation : reservationRepository.getAll()) {
            if (reservation.getDate().contains(text) ||
                    reservation.getTime().contains(text)) {
                results.add(reservation);
            }
        }
        return results;
    }
}