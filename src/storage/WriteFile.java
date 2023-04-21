package storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteFile<Candidates>{
    public void writeFile(ArrayList<Candidates>candidates ){
        File file = new File("src/list.txt");
        try{
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(candidates);
            outputStream.close();
            objectOutputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
