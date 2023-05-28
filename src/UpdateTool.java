
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UpdateTool {
    public void CLEAN(String database){
        try {
            FileWriter writer = new FileWriter(database,false);
        } catch (IOException ex) {
            Logger.getLogger(UpdateTool.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public void WriteContentToDatabase(String content,String database) {
        try {
            try (FileWriter writer = new FileWriter(database,true)) {
                writer.write(content);
            }
        } catch (IOException e) {
        e.printStackTrace();
    }
      


    }
    
}
