
import java.util.ArrayList;


public class Examination implements IExamination{
    
    private int ExaminationCost;
    private String ExaminationType;
    private ArrayList<Operation> Operations;

    public Examination(int ExaminationCost, String ExaminationType) {
        this.ExaminationCost = ExaminationCost;
        this.ExaminationType = ExaminationType;
        Operations = new ArrayList<>();
    }

    public double getExaminationCost() {
        return ExaminationCost;
    }

    public void setExaminationCost(int ExaminationCost) {
        this.ExaminationCost = ExaminationCost;
    }

    public String getExaminationType() {
        return ExaminationType;
    }

    public void setExaminationType(String ExaminationType) {
        this.ExaminationType = ExaminationType;
    }

    public ArrayList<Operation> getOperations() {
        return Operations;
    }

    public void setOperations(ArrayList<Operation> Operations) {
        this.Operations = Operations;
    }
    
    @Override
    public void AddOperation(Operation NewOperation) {
        if(!NewOperation.getEmbeddedOperations().isEmpty()){
            Operations.add(NewOperation);
            for(int i=0;i<NewOperation.getEmbeddedOperations().size();i++){
                Operations.add(NewOperation.getEmbeddedOperations().get(i));
            }

        }
        else{
            Operations.add(NewOperation);
        }
    
    }

    @Override
    public int TotalCost() {
        int CostOfOperations = 0;
        for(Operation operation : Operations){
            CostOfOperations+=operation.TotalCost();
        }
        return CostOfOperations+ExaminationCost;

    }

    @Override
    public String Info() {
        String info ="";
        for(Operation operation : Operations){
            info+= operation.Info()+" ";
        }
        return info;
    }
    
    
    
    
    
}
