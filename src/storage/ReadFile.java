package storage;

import model.Candidates;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile<Candidates> {
    public ArrayList<Candidates>readFile(){
        File file = new File("D:\\Md2\\CaseStudy_MD2\\CaseStudy\\src\\list.txt");
        ArrayList<Candidates>candidates = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            candidates = (ArrayList<Candidates>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return candidates;
    }
}
