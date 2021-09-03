package test;

import movies.negocio.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int response = 0;
        IMovieCatalog movieCatalog = new MovieCatalogImpl();

        do {
            System.out.println("Choose an option: ");
            System.out.println("1. Init movie catalogue");
            System.out.println("2. Add movie");
            System.out.println("3. List movies");
            System.out.println("4. Search movie");
            System.out.println("0. Exit");

            try {
                response = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                e.printStackTrace(System.out);
            }

            switch (response) {
                case 1:
                    movieCatalog.initMovieCatalog();
                    break;
                case 2:
                    System.out.println("Enter the name of the movie");
                    String movieName = sc.nextLine();
                    movieCatalog.addMovie(movieName);
                    break;
                case 3:
                    movieCatalog.listMovies();
                    break;
                case 4:
                    System.out.println("Enter a movie to search");
                    String movieToSearch = sc.nextLine();
                    movieCatalog.searchMovie(movieToSearch);
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please digit a valid number");
            }
        } while (response != 0);
    }
}
