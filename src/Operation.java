
import java.util.ArrayList;


public class Operation implements HMSComponents{
        
    private String name;
    private int cost;
    private ArrayList<Operation> embeddedOperations;

    public Operation(String name, int cost) {
        embeddedOperations = new ArrayList<>();
        this.name = name;
        this.cost = cost;
    }

    public Operation(Operation NewOperation) {
        embeddedOperations = new ArrayList<>();
        if(NewOperation.getEmbeddedOperations().isEmpty()){
            embeddedOperations.add(NewOperation);    
        }
        else if(NewOperation.getEmbeddedOperations().size() == 1){
            embeddedOperations.add(NewOperation);
            embeddedOperations.add(NewOperation.getEmbeddedOperations().get(0));
        }  
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<Operation> getEmbeddedOperations() {
        return embeddedOperations;
    }

    public void setEmbeddedOperations(ArrayList<Operation> embeddedOperations) {
        this.embeddedOperations = embeddedOperations;
    }

    @Override
    public String Info() {
        return name;
    }

    @Override
    public int TotalCost() {
        return cost;
    }
    
    
    
    
    
    
}
