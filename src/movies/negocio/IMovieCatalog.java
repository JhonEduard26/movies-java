package movies.negocio;

public interface IMovieCatalog {

    void addMovie(String movieName, String fileName);

    void listMovies(String fileName);

    void searchMovie(String fileName, String movieName);

    void initFile(String fileName);
}
