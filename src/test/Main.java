package test;

import movies.negocio.IMovieCatalog;
import movies.negocio.MovieCatalogImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int response = 0;
        String fileName = "movies.txt";
        IMovieCatalog movieCatalog = new MovieCatalogImpl();

        do {
            System.out.println("1. Init movie catalogue");
            System.out.println("2. Add movie");
            System.out.println("3. List movies");
            System.out.println("4. Search movie");
            System.out.println("0. Exit");

            try {
                response = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                e.printStackTrace(System.out);
            }

            switch (response) {
                case 1:
                    movieCatalog.initFile(fileName);
                    break;
                case 2:
                    movieCatalog.addMovie("Captain America",fileName);
                    break;
                case 3:
                    movieCatalog.listMovies(fileName);
                    break;
                case 4:
                    movieCatalog.searchMovie(fileName, "Captain America");
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
