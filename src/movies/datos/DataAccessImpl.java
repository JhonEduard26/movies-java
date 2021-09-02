package movies.datos;

import movies.domain.Movies;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccessImpl implements IDataAccess{

    @Override
    public boolean isExist(String fileName) {
        return false;
    }

    @Override
    public List<Movies> list(String fileName) {
        List<Movies> myList = new ArrayList<>();
        File file = new File(fileName);
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String read = input.readLine();
            myList.add(new Movies(read));
            while(read != null) {
                System.out.println(read);
                read = input.readLine();
                myList.add(new Movies(read));
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myList;
    }

    @Override
    public void write(Movies movies, String fileName, boolean append) {
        File file = new File(fileName);
        if (!append) {
            try {
                PrintWriter exit = new PrintWriter(file);
                exit.println(movies);
                exit.close();
                System.out.println("The movie was added correctly");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try{
                PrintWriter exit = new PrintWriter(new FileWriter(file, true));
                exit.println(movies);
                exit.close();
                System.out.println("File was overwrote and the movie was added correctly");
            }catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
