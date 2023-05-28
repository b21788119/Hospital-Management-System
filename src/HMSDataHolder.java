
import java.util.ArrayList;


public class HMSDataHolder {
    
    private ArrayList<Patient> AllPatients ;
    private ArrayList<Admission> AllAdmissions ;
    
    public HMSDataHolder(String[] PatientInfos,String[] AdmissionInfos){
        AllAdmissions = new ArrayList<>();
        AllPatients = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        for(String info : PatientInfos){
            String[] SplittedInfo = info.split("\\s+");
            int PatientID = Integer.parseInt(SplittedInfo[0]);
            String name = SplittedInfo[1];
            String surname = SplittedInfo[2];
            String number = SplittedInfo[3];
            String address = "";
            for(int i=4;i<SplittedInfo.length;i++){
                if(i == SplittedInfo.length-1){
                    address+=SplittedInfo[i];
                }
                else{
                    address+=SplittedInfo[i]+" ";
                }
            }
            AllPatients.add(index1,new Patient(name,surname,PatientID,number,address));
            index1++;
        }
        for(String info:AdmissionInfos){
            String[] SplittedInfo = info.split("\\s+");
            if(SplittedInfo[0].startsWith("Out")){
                switch(SplittedInfo.length){
                    case 2:
                        String command1 = String.valueOf(SplittedInfo[1].charAt(0));
                        Examination examination = new OneOperationAdder(new OutpatientExamination(), command1).getDecoratedExamination();
                        AllAdmissions.get(index2-1).AddExamination(examination);
                        break;
                    case 3:
                        String command2 = String.valueOf(SplittedInfo[1].charAt(0)) + String.valueOf(SplittedInfo[2].charAt(0));
                        Examination examination1 = new TwoOperationsAdder(new OutpatientExamination(), command2).getDecoratedExamination();
                        AllAdmissions.get(index2-1).AddExamination(examination1);
                        break;
                    case 4:
                        String command3 = String.valueOf(SplittedInfo[1].charAt(0)) + String.valueOf(SplittedInfo[2].charAt(0))+ String.valueOf(SplittedInfo[3].charAt(0));
                        Examination examination2 = new ThreeOperationsAdder(new OutpatientExamination(), command3).getDecoratedExamination();
                        AllAdmissions.get(index2-1).AddExamination(examination2);
                        break;
                }
            }
            else if(SplittedInfo[0].startsWith("In")){
                
                 switch(SplittedInfo.length){
                    case 2:
                        String command1 = String.valueOf(SplittedInfo[1].charAt(0));
                        Examination examination = new OneOperationAdder(new InpatientExamination(), command1).getDecoratedExamination();
                        AllAdmissions.get(index2-1).AddExamination(examination);
                        break;
                    case 3:
                        String command2 = String.valueOf(SplittedInfo[1].charAt(0)) + String.valueOf(SplittedInfo[2].charAt(0));
                        Examination examination1 = new TwoOperationsAdder(new InpatientExamination(), command2).getDecoratedExamination();
                        AllAdmissions.get(index2-1).AddExamination(examination1);
                        break;
                    case 4:
                        String command3 = String.valueOf(SplittedInfo[1].charAt(0)) + String.valueOf(SplittedInfo[2].charAt(0))+ String.valueOf(SplittedInfo[3].charAt(0));
                        Examination examination2 = new ThreeOperationsAdder(new InpatientExamination(), command3).getDecoratedExamination();
                        AllAdmissions.get(index2-1).AddExamination(examination2);
                        break;
                }
            }
            else{
                int AdmissionID = Integer.parseInt(SplittedInfo[0]);
                int PatientID = Integer.parseInt(SplittedInfo[1]);
                AllAdmissions.add(index2,new Admission(AdmissionID, PatientID));
                for(Patient patient : AllPatients){
                    if(patient.getPatientID() == PatientID){
                        patient.AddAdmission(new Admission(AdmissionID,PatientID));
                    }
                }
                index2++;
            }
        }
    }
    public ArrayList<Patient> getAllPatients() {
        return AllPatients;
    }

    public void setAllPatients(ArrayList<Patient> AllPatients) {
        this.AllPatients = AllPatients;
    }

    public ArrayList<Admission> getAllAdmissions() {
        return AllAdmissions;
    }

    public void setAllAdmissions(ArrayList<Admission> AllAdmissions) {
        this.AllAdmissions = AllAdmissions;
    }
}
