
import java.util.ArrayList;


public interface DAO {
    void Connect(String database);
    void Connect(String database1,String database2);
    Object getByID(int ID,int command); 
    void deleteByID(int ID); 
    void add(Object object);                                    // I have applied method overloading to use this DAO in another projects.
    void add(Object object,int ID);
    ArrayList getALL();
    void Update(String database1,String database2);
    void Update(String database);
    void Disconnect();
}
