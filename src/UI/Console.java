package UI;

import Domain.ClientCard;
import Domain.Movie;
import Domain.Reservation;
import Service.ClientCardService;
import Service.MovieService;
import Service.ReservationService;

import java.util.Scanner;

public class Console {

    private MovieService movieService;
    private ClientCardService clientCardService;
    private ReservationService reservationService;
    private Scanner scanner;

    public Console(MovieService movieService, ClientCardService clientCardService, ReservationService reservationService) {
        this.movieService = movieService;
        this.clientCardService = clientCardService;
        this.reservationService = reservationService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Movie CRUD operations");
        System.out.println("2. Client Card CRUD operations");
        System.out.println("3. Reservation CRUD operations");
        System.out.println("4. Search clients");
        System.out.println("5. Search movies");
        System.out.println("6. Search reservations");
        System.out.println("x. Exit");
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            showMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovieCrud();
                    break;
                case "2":
                    runClientCardCrud();
                    break;
                case "3":
                    runReservationCrud();
                    break;
                case "4":
                    runClientsSearch();
                    break;
                case "5":
                    runMoviesSearch();
                    break;
                case "6":
                    runReservationsSearch();
                    break;
                case "x":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void runMoviesSearch() {
        System.out.println("Search: ");
        String text = scanner.nextLine();
        System.out.println("Results are: ");
        for (Movie movie : movieService.fullTextSearch(text)) {
            System.out.println(movie);
        }
    }

    private void runReservationsSearch() {
        System.out.println("Search: ");
        String text = scanner.nextLine();
        System.out.println("Results are: ");
        for (Reservation reservation : reservationService.fullTextSearch(text)) {
            System.out.println(reservation);
        }
    }

    private void runClientsSearch() {
        System.out.println("Search: ");
        String text = scanner.nextLine();
        System.out.println("Results are: ");
        for (ClientCard clientCard : clientCardService.fullTextSearch(text)) {
            System.out.println(clientCard);
        }
    }

    private void runReservationCrud() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add a reservation");
            System.out.println("2. Update a reservation");
            System.out.println("3. Remove a reservation");
            System.out.println("4. Show all reservations");
            System.out.println("5. Back");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddReservation();
                    break;
                case "2":
                    handleUpdateReservation();
                    break;
                case "3":
                    handleRemoveReservation();
                    break;
                case "4":
                    handleViewReservations();
                    break;
                case "5":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleViewReservations() {
        for (Reservation reservation : reservationService.getAll()) {
            System.out.println(reservation);
        }
    }

    private void handleRemoveReservation() {
        try {
            System.out.print("Enter the id to remove: ");
            Long id = Long.valueOf(scanner.nextLine());
            reservationService.remove(id);
            System.out.println("Reservation removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddReservation() {
        try {
            System.out.print("Enter id: ");
            Long id = Long.valueOf(scanner.nextLine());
            System.out.print("Enter movie id: ");
            Long idMovie = Long.valueOf(scanner.nextLine());
            System.out.print("Enter client card id: ");
            Long idClientCard = Long.valueOf(scanner.nextLine());
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter time: ");
            String time = scanner.nextLine();
            reservationService.insert(id, idMovie, idClientCard, date, time);
            System.out.println("Added reservation");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleUpdateReservation() {
        try {
            System.out.print("Enter id: ");
            Long id = Long.valueOf(scanner.nextLine());
            System.out.print("Enter movie id: ");
            Long idMovie = Long.valueOf(scanner.nextLine());
            System.out.print("Enter client card id: ");
            Long idClientCard = Long.valueOf(scanner.nextLine());
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter time: ");
            String time = scanner.nextLine();
            reservationService.update(id, idMovie, idClientCard, date, time);
            System.out.println("Reservation added");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runClientCardCrud() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add a client card");
            System.out.println("2. Update a client card");
            System.out.println("3. Remove a client card");
            System.out.println("4. View all client cards");
            System.out.println("5. Back");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddClientCard();
                    break;
                case "2":
                    handleUpdateClientCard();
                    break;
                case "3":
                    handleRemoveClientCard();
                    break;
                case "4":
                    handleViewClientCards();
                    break;
                case "5":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleViewClientCards() {
        for (ClientCard clientCard : clientCardService.getAll()) {
            System.out.println(clientCard);
        }
    }

    private void handleRemoveClientCard() {
        try {
            System.out.print("Enter the id of the client card to remove: ");
            Long id = Long.valueOf(scanner.nextLine());
            clientCardService.remove(id);
            System.out.println("Client card removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddClientCard() {
        try {
            System.out.print("Enter id: ");
            Long id = Long.valueOf(scanner.nextLine());
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter CNP: ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration: ");
            String dateOfRegistration = scanner.nextLine();
            clientCardService.insert(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
            System.out.println("Client card added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleUpdateClientCard() {
        try {
            System.out.print("Enter id: ");
            Long id = Long.valueOf(scanner.nextLine());
            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter CNP: ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth: ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration: ");
            String dateOfRegistration = scanner.nextLine();
            clientCardService.update(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
            System.out.println("Client card added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runMovieCrud() {
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add a movie");
            System.out.println("2. Update a movie");
            System.out.println("3. Remove a movie");
            System.out.println("4. View all movies");
            System.out.println("5. Back");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddMovie();
                    break;
                case "2":
                    handleUpdateMovie();
                    break;
                case "3":
                    handleRemoveMovie();
                    break;
                case "4":
                    handleViewMovies();
                    break;
                case "5":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void handleViewMovies() {
        for (Movie movie : movieService.getAll()) {
            System.out.println(movie);
        }
    }

    private void handleRemoveMovie() {
        try {
            System.out.print("Enter the id of the movie to remove: ");
            Long id = Long.valueOf(scanner.nextLine());
            movieService.remove(id);
            System.out.println("Movie removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddMovie() {
        try {
            System.out.print("Enter movie id: ");
            Long id = Long.valueOf(scanner.nextLine());
            System.out.print("Enter movie title: ");
            String title = scanner.nextLine();
            System.out.print("Enter release year: ");
            Integer year = scanner.nextInt();
            System.out.print("Enter ticket price: ");
            Double ticketPrice = scanner.nextDouble();
            System.out.print("Enter availability (true / false): ");
            Boolean available = scanner.nextBoolean();
            movieService.insert(id, title, year, ticketPrice, available);
            System.out.println("Movie added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleUpdateMovie() {
        try {
            System.out.print("Enter movie id: ");
            Long id = Long.valueOf(scanner.nextLine());
            System.out.print("Enter movie title: ");
            String title = scanner.nextLine();
            System.out.print("Enter release year: ");
            Integer year = scanner.nextInt();
            System.out.print("Enter ticket price: ");
            Double ticketPrice = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter availability (true / false): ");
            Boolean available = Boolean.parseBoolean(scanner.nextLine());
            movieService.update(id, title, year, ticketPrice, available);
            System.out.println("Movie added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}