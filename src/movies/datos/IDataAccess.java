package movies.datos;

import movies.domain.Movies;
import movies.excepciones.*;
import java.util.List;

public interface IDataAccess {

    boolean isExist(String fileName) throws DataAccessEx;

    List<Movies> list(String fileName) throws ReadDataEx;

    void write(Movies movies, String fileName, boolean append) throws WriteDataEx;

    String search(String fileName, String movieName) throws ReadDataEx;

    void create(String fileName) throws DataAccessEx;

    void delete(String fileName) throws DataAccessEx;
}
