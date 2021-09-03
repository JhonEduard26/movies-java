package movies.datos;

import movies.domain.Movies;
import movies.excepciones.*;
import java.io.*;
import java.util.*;

public class DataAccessImpl implements IDataAccess{

    @Override
    public boolean isExist(String fileName){
        File file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<Movies> list(String fileName) throws ReadDataEx {
        List<Movies> myList = new ArrayList<>();
        File file = new File(fileName);
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String read = input.readLine();
            while(read != null) {
                myList.add(new Movies(read));
                read = input.readLine();
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception to list movies: " + e.getMessage());
        }
        return myList;
    }

    @Override
    public void write(Movies movies, String fileName, boolean append) throws WriteDataEx {
        File file = new File(fileName);
            try{
                PrintWriter exit = new PrintWriter(new FileWriter(file, append));
                exit.println(movies);
                exit.close();
                System.out.println("The movie was added correctly");
            }catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace();
                throw new WriteDataEx("Exception to write movies: " + e.getMessage());
            }
    }

    @Override
    public String search(String fileName, String movieName) throws ReadDataEx{
        File file = new File(fileName);
        String result = "The movie was not found";
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String read = input.readLine();
            int index = 1;
            while (read != null) {
                if (movieName != null && movieName.equalsIgnoreCase(read)) {
                    result = "Movie: " + read + " found in the index: " + index;
                    break;
                }
                read = input.readLine();
                index += 1;
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ReadDataEx("Exception to search movies: " + e.getMessage());
        }
        return result;
    }

    @Override
    public void create(String fileName) throws DataAccessEx {
        File file = new File(fileName);

        try {
            PrintWriter output = new PrintWriter(new FileWriter(file));
            output.close();
            System.out.println("File was created");
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataAccessEx("Exception to create file" + e.getMessage());
        }
    }

    @Override
    public void delete(String fileName){
        File file = new File(fileName);
        if (file.exists()){
            file.delete();
            System.out.println("The file was deleted");
        }
    }
}
