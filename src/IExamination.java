
public interface IExamination extends HMSComponents{
    
    void AddOperation(Operation operation);
    @Override
    int TotalCost();

    @Override
    String Info();
    
    
    
}
