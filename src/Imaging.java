
public class Imaging extends Operation {
    
    public Imaging(){
        super("imaging",10);
    }
    public Imaging(Operation operation){
        super(operation);
        super.setCost(10);
        super.setName("imaging");
    }
}
