package movies.negocio;

public interface IMovieCatalog {

    String FILE_NAME = "movies.txt";

    void addMovie(String movieName);

    void listMovies();

    void searchMovie(String movieName);

    void initMovieCatalog();
}
