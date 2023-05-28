
public final class OneOperationAdder extends ExaminationDecorator{
    
    @Override
    public void ADD(String command){
        switch (command) {
            case "i":
                getDecoratedExamination().AddOperation(new Imaging());
                break;
            case "t":
                getDecoratedExamination().AddOperation(new Tests());
                break;
            case "m":
                getDecoratedExamination().AddOperation(new Measurements());
                break;
            case "d":
                getDecoratedExamination().AddOperation(new DoctorVisit());
                break;
            default:
                break;
        }
    }

    public OneOperationAdder(Examination Examination, String command) {
        super(Examination, command);
        ADD(command);
    }
    
    @Override
    public void AddOperation(Operation operation) {
        getDecoratedExamination().AddOperation(operation);
    }

    @Override
    public int TotalCost() {
        return getDecoratedExamination().TotalCost();

    }

    @Override
    public String Info() {
        return getDecoratedExamination().Info();
        
    }

    
    
    
    
    
}
