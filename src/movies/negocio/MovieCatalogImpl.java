package movies.negocio;

import movies.datos.*;

public class MovieCatalogImpl implements IMovieCatalog{

    IDataAccess iDataAccess = new DataAccessImpl();

    public MovieCatalogImpl() {
    }

    @Override
    public void addMovie(String movieName, String fileName) {

    }

    @Override
    public void listMovies(String fileName) {

    }

    @Override
    public void searchMovie(String fileName, String movieName) {

    }

    @Override
    public void initFile(String fileName) {
        iDataAccess.create(fileName);
    }
}
