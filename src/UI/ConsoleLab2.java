package UI;

import Domain.Movie;
import Service.MovieService;

import java.util.Scanner;

public class ConsoleLab2 {

    private MovieService movieService;
    private Scanner scanner;

    public ConsoleLab2(MovieService movieService) {
        this.movieService = movieService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Movie CRUD operations");
        System.out.println("2. Client Card CRUD operations");
        System.out.println("3. Reservation CRUD operations");
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
                case "x":
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private void runMovieCrud() {
        String option = scanner.nextLine();
        String[] parts = option.split(",");
        if (parts[0].equalsIgnoreCase("remove")) {
            try {
                movieService.remove(Long.valueOf(parts[1]));
                System.out.println("Movie removed!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }
        if (parts[0].equalsIgnoreCase("add")) {
            try {
                movieService.insert(Long.valueOf(parts[1]),
                        parts[2],
                        Integer.valueOf(parts[3]),
                        Double.valueOf(parts[4]),
                        Boolean.valueOf(parts[5]));
                System.out.println("Movie added!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }
        if (parts[0].equalsIgnoreCase("update")) {
            try {
                movieService.update(Long.valueOf(parts[1]),
                        parts[2],
                        Integer.valueOf(parts[3]),
                        Double.valueOf(parts[4]),
                        Boolean.valueOf(parts[5]));
                System.out.println("Movie updated!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }
        if (parts[0].equalsIgnoreCase("getAll")) {
            for (Movie movie : movieService.getAll()) {
                System.out.println(movie);
            }
        }

    }
}