
public class Measurements extends Operation {
    public Measurements(){
        super("measurements",5);
    }
    public Measurements(Operation operation){
        super(operation);
        super.setCost(5);
        super.setName("measurements");
    }
}
