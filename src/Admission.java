
import java.util.ArrayList;


public class Admission implements HMSComponents{
    
    private int AdmissionID;
    private int PatientID;
    private ArrayList<Examination> Examinations;

    public Admission(int AdmissionID, int PatientID) {
        this.AdmissionID = AdmissionID;
        this.PatientID = PatientID;
        Examinations = new ArrayList<>();
    }

    public int getAdmissionID() {
        return AdmissionID;
    }

    public void setAdmissionID(int AdmissionID) {
        this.AdmissionID = AdmissionID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public ArrayList<Examination> getExaminations() {
        return Examinations;
    }

    public void setExaminations(ArrayList<Examination> Examinations) {
        this.Examinations = Examinations;
    }
    
    @Override
    public int TotalCost() {
        int AdmissionCost = 0;
        for(Examination examination : Examinations){
            AdmissionCost+=examination.TotalCost();
        }
        return AdmissionCost;
    }

    @Override
    public String Info() {
        String info = AdmissionID+"\t"+PatientID+"\n";
        for(Examination examination:Examinations){
            info+=examination.getExaminationType()+"\t"+examination.Info()+"\n";
        }
        return info;
    }
    public String CreateAndSendBill(){
        String topic = "TotalCost for Admission "+AdmissionID;
        String Bill ="";
        for(Examination examination:Examinations){
            Bill+="\t"+examination.getExaminationType()+" "+examination.Info()+examination.TotalCost()+"$\n";
        }
        String total = "\tTotal: "+String.valueOf(TotalCost())+"$";
        return topic+"\n"+Bill+total;
        
    }

    public void AddExamination(Examination newExamination){
        Examinations.add(newExamination);
    }

    
    
    
}
