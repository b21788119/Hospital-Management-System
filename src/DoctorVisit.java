
public class DoctorVisit extends Operation{
    
    public DoctorVisit(){
        super("doctorvisit",15);
    }
    public DoctorVisit(Operation operation){
        super(operation);
        super.setCost(15);
        super.setName("doctorvisit");
    }
}
