
public class Tests extends Operation {
    
    public Tests(){
        super("tests",7);
    }
    public Tests(Operation operation){
        super(operation);
        super.setCost(7);
        super.setName("tests");
    }
    
}
