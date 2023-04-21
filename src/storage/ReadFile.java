package storage;

import model.Candidates;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<Candidates>readFile(){
        File file = new File("List.txt");
        List<Candidates>candidates = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream fis = new ObjectInputStream(is);
            candidates = (List<Candidates>) fis.readObject();
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    return candidates;
    }
}
