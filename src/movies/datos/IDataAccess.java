package movies.datos;

import movies.domain.Movies;

import java.util.List;

public interface IDataAccess {

    boolean isExist(String fileName);

    List<Movies> list(String fileName);

    void write(Movies movies, String fileName, boolean append);

    String search(String fileName, String movieName);

    void create(String fileName);

    void delete(String fileName);
}
