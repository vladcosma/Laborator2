import Domain.ClientCard;
import Domain.Movie;
import Domain.Reservation;
import Repository.BaseRepository;
import Repository.InMemoryRepository;
import Service.ClientCardService;
import Service.MovieService;
import Service.ReservationService;
import UI.Console;
import Validator.ClientCardValidator;
import Validator.MovieValidator;
import Validator.ReservationValidator;
import Validator.Validator;

public class Main {

    public static void main(String[] args) {

        Validator<Movie> movieValidator = new MovieValidator();
        Validator<ClientCard> clientCardValidator = new ClientCardValidator();
        Validator<Reservation> reservationValidator = new ReservationValidator();

        BaseRepository<Movie> movieRepository = new InMemoryRepository<Movie>(movieValidator);
        BaseRepository<ClientCard> clientCardRepository = new InMemoryRepository<ClientCard>(clientCardValidator);
        BaseRepository<Reservation> reservationRepository = new InMemoryRepository<Reservation>(reservationValidator);

        MovieService movieService = new MovieService(movieRepository);
        ClientCardService clientCardService = new ClientCardService(clientCardRepository);
        ReservationService reservationService = new ReservationService(reservationRepository, movieRepository, clientCardRepository);

        Console console = new Console(movieService, clientCardService, reservationService);
        console.run();
    }
}