
public final class TwoOperationsAdder extends ExaminationDecorator{
    

    @Override
    void ADD(String command) {
         switch (command) {
            case "im":
                getDecoratedExamination().AddOperation(new Imaging(new Measurements()));
                break;
            case "mi":
                getDecoratedExamination().AddOperation(new Measurements(new Imaging()));
                break;
            case "it":
                getDecoratedExamination().AddOperation(new Imaging(new Tests()));
                break;
            case "ti":
                getDecoratedExamination().AddOperation(new Tests(new Imaging()));
                break;
            case "id":
                getDecoratedExamination().AddOperation(new Imaging(new DoctorVisit()));
                break;
            case "di":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Imaging()));
                break;
            case "tm":
                getDecoratedExamination().AddOperation(new Tests(new Measurements()));
                break;
            case "mt":
                getDecoratedExamination().AddOperation(new Measurements(new Tests()));
                break;
            case "td":
                getDecoratedExamination().AddOperation(new Tests(new DoctorVisit()));
                break;
            case "dt":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Tests()));
                break;
            case "md":
                getDecoratedExamination().AddOperation(new Measurements(new DoctorVisit()));
                break;
            case "dm":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Measurements()));
                break;
            default:
                break;
        }
    }
    
    public TwoOperationsAdder(Examination Examination, String command) {
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
