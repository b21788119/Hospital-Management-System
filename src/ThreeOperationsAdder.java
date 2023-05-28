
public final class ThreeOperationsAdder extends ExaminationDecorator{

    @Override
    void ADD(String command) {
        switch (getCommand()) {
            case "imt":
                getDecoratedExamination().AddOperation(new Imaging(new Measurements(new Tests())));
                break;
            case "itm":
                getDecoratedExamination().AddOperation(new Imaging(new Tests(new Measurements())));
                break;
            case "mit":
                getDecoratedExamination().AddOperation(new Measurements(new Imaging(new Tests())));
                break;
            case "tim":
                getDecoratedExamination().AddOperation(new Tests(new Imaging(new Measurements())));
                break;
            case "tmi":
                getDecoratedExamination().AddOperation(new Tests(new Measurements(new Imaging())));
                break;
            case "mti":
                getDecoratedExamination().AddOperation(new Measurements(new Tests(new Imaging())));
                break;
            case "imd":
                getDecoratedExamination().AddOperation(new Imaging(new Measurements(new DoctorVisit())));
                break;
            case "idm":
                getDecoratedExamination().AddOperation(new Imaging(new DoctorVisit(new Measurements())));
                break;
            case "mid":
                getDecoratedExamination().AddOperation(new Measurements(new Imaging(new DoctorVisit())));
                break;
            case "dim":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Imaging(new Measurements())));
                break;
            case "dmi":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Measurements(new Imaging())));
                break;
            case "mdi":
                getDecoratedExamination().AddOperation(new Measurements(new DoctorVisit(new Imaging())));
                break;
            case "itd":
                getDecoratedExamination().AddOperation(new Imaging(new Tests(new DoctorVisit())));
                break;
            case "idt":
                getDecoratedExamination().AddOperation(new Imaging(new DoctorVisit(new Tests())));
                break;
            case "tid":
                getDecoratedExamination().AddOperation(new Tests(new Imaging(new DoctorVisit())));
                break;
            case "dit":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Imaging(new Tests())));
                break;
            case "dti":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Tests(new Imaging())));
                break;
            case "tdi":
                getDecoratedExamination().AddOperation(new Tests(new DoctorVisit(new Imaging())));
                break;
            case "mtd":
                getDecoratedExamination().AddOperation(new Measurements(new Tests(new DoctorVisit())));
                break;
            case "mdt":
                getDecoratedExamination().AddOperation(new Measurements(new DoctorVisit(new Tests())));
                break;
            case "tmd":
                getDecoratedExamination().AddOperation(new Tests(new Measurements(new DoctorVisit())));
                break;
            case "dmt":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Measurements(new Tests())));
                break;
            case "dtm":
                getDecoratedExamination().AddOperation(new DoctorVisit(new Tests(new Measurements())));
                break;
            case "tdm":
                getDecoratedExamination().AddOperation(new Tests(new DoctorVisit(new Measurements())));
                break;
            default:
                break;
        }
    }
    public ThreeOperationsAdder(Examination Examination, String command) {
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
