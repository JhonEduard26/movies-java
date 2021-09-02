package movies.negocio;

import movies.datos.*;
import movies.domain.Movies;

public class MovieCatalogImpl implements IMovieCatalog{

    IDataAccess iDataAccess = new DataAccessImpl();

    public MovieCatalogImpl() {
    }

    @Override
    public void addMovie(String movieName, String fileName) {
        iDataAccess.write(new Movies(movieName), fileName, true);
    }

    @Override
    public void listMovies(String fileName) {
        iDataAccess.list(fileName);
    }

    @Override
    public void searchMovie(String fileName, String movieName) {
        iDataAccess.search(fileName, movieName);
    }

    @Override
    public void initFile(String fileName) {
        iDataAccess.create(fileName);
    }
}
