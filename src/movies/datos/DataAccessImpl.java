package movies.datos;

import movies.domain.Movies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class DataAccessImpl implements IDataAccess{

    @Override
    public boolean isExist(String fileName) {
        return false;
    }

    @Override
    public List<Movies> list() {
        return null;
    }

    @Override
    public void write(Movies movies, String fileName, boolean append) {

    }

    @Override
    public String search(String fileName, String movieName) {
        return null;
    }

    @Override
    public void create(String fileName) {
        File file = new File(fileName);

        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.close();
            System.out.println("File was created");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String fileName) {

    }
}
