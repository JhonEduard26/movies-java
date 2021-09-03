package movies.negocio;

import movies.datos.*;
import movies.domain.Movies;
import movies.excepciones.DataAccessEx;
import java.util.List;

public class MovieCatalogImpl implements IMovieCatalog{

    private final IDataAccess iDataAccess;

    public MovieCatalogImpl() {
        this.iDataAccess = new DataAccessImpl();
    }

    @Override
    public void addMovie(String movieName) {
        Movies movies = new Movies(movieName);
        boolean append = false;
        try {
            append = iDataAccess.isExist(FILE_NAME);
            iDataAccess.write(movies, FILE_NAME, append);
        } catch (DataAccessEx e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listMovies() {
        try {
            List<Movies> movies = this.iDataAccess.list(FILE_NAME);
            for (Movies movie: movies) {
                System.out.println(movie);
            }
        } catch (DataAccessEx e) {
            System.out.println("Data access error");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void searchMovie(String movieName) {
        String result = null;
        try {
            result = this.iDataAccess.search(FILE_NAME, movieName);
        } catch (DataAccessEx e) {
            System.out.println("Data access error");
            e.printStackTrace();
        }
        System.out.println(result);
    }

    @Override
    public void initMovieCatalog() {
        try {
            if (this.iDataAccess.isExist(FILE_NAME)){
                iDataAccess.delete(FILE_NAME);
                iDataAccess.create(FILE_NAME);
            }
        } catch (DataAccessEx e) {
            System.out.println("Error when starting movie catalog");
            e.printStackTrace(System.out);
        }
    }
}
