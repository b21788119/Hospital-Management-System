
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class HMS {
    private DAO dao;
    private String Interface="";
    private String[] target_databases;

    public HMS(DAO dao,String database1,String database2) {
        target_databases = new String[2];
        target_databases[0] = database1;
        target_databases[1] = database2;
        this.dao = dao;
    }
    public void NewPatient(Patient newPatient){
        dao.add(newPatient);
        Interface+= "Patient "+newPatient.getPatientID()+" "+newPatient.getName()+" added.\n";
    }
     public void RemovePatient(int ID){
        Patient RemovedPatient = (Patient)dao.getByID(ID,1);
        Interface+= "Patient "+RemovedPatient.getPatientID()+" "+RemovedPatient.getName()+" removed.\n";
        dao.deleteByID(ID);
    }
     public void ListPatients(){
        Interface+= "Patient List:\n";
        ArrayList<Patient> allPatients = dao.getALL();
        for(int i=0;i<allPatients.size();i++){
            Interface+= allPatients.get(i).Info()+"\n";
        }
    }
    public void CreateAdmission(Admission newAdmission){
         dao.add(newAdmission);
         Interface+= "Admission "+newAdmission.getAdmissionID()+" created.\n";
    }
    public void AddExamination(Examination newExamination,int ID){
        dao.add(newExamination, ID);
        Interface+=newExamination.getExaminationType()+" examination added to admission "+ID+".\n";
    }
    public void TotalCost(int AdmissionID){
        Admission selected = (Admission)dao.getByID(AdmissionID,2);
        Interface+= selected.CreateAndSendBill()+"\n";
    }
    public void RUN(String[] inputData){
        dao.Connect(target_databases[0],target_databases[1]);
        
        for(String line:inputData){
            String[] splittedLine = line.split("\\s+");
            switch(splittedLine[0]){
                case "AddPatient":
                    int ID = Integer.parseInt(splittedLine[1]);
                    String name = splittedLine[2];
                    String surname = splittedLine[3];
                    String number = splittedLine[4];
                    String address = "Address: ";
                    for(int i=5;i<splittedLine.length;i++){
                        if(i!= splittedLine.length-1){
                            address+=splittedLine[i]+" ";
                        }
                        else{
                            address+= splittedLine[i];
                        
                        }
                    }
                    NewPatient(new Patient(name, surname,ID, number, address));
                    break;
                case "RemovePatient":
                    RemovePatient(Integer.parseInt(splittedLine[1]));
                    break;
                case "CreateAdmission":
                    CreateAdmission(new Admission(Integer.parseInt(splittedLine[1]),Integer.parseInt(splittedLine[2])));
                    break;
                case "AddExamination":
                    int ID_ = Integer.parseInt(splittedLine[1]);
                    int numberOfOperations = splittedLine.length -3;
                    boolean typeControl = splittedLine[2].startsWith("In");
                    if(numberOfOperations == 1){
                        if(typeControl){
                            String command = String.valueOf(splittedLine[3].charAt(0));
                            Examination examination = new OneOperationAdder(new InpatientExamination(),command).getDecoratedExamination();
                            AddExamination(examination, ID_);
                        }
                        else{
                            String command = String.valueOf(splittedLine[3].charAt(0));
                            Examination examination = new OneOperationAdder(new OutpatientExamination(),command).getDecoratedExamination();
                            AddExamination(examination, ID_);
                        }
                    }
                    else if(numberOfOperations == 2){
                        if(typeControl){
                            String command = String.valueOf(splittedLine[3].charAt(0)) + String.valueOf(splittedLine[4].charAt(0)) ;                                          ;
                            Examination examination = new TwoOperationsAdder(new InpatientExamination(), command).getDecoratedExamination();
                            AddExamination(examination, ID_);
                        }
                        else{
                            String command = String.valueOf(splittedLine[3].charAt(0))+String.valueOf(splittedLine[4].charAt(0));
                            Examination examination = new TwoOperationsAdder(new OutpatientExamination(),command).getDecoratedExamination();
                            AddExamination(examination, ID_);
                        }
                    }
                    else if(numberOfOperations==3){
                        if(typeControl){
                            String command = String.valueOf(splittedLine[3].charAt(0))+String.valueOf(splittedLine[4].charAt(0))+String.valueOf(splittedLine[5].charAt(0));
                            Examination examination = new ThreeOperationsAdder(new InpatientExamination(),command).getDecoratedExamination();
                            AddExamination(examination, ID_);
                        }
                        else{
                            String command = String.valueOf(splittedLine[3].charAt(0))+String.valueOf(splittedLine[4].charAt(0))+String.valueOf(splittedLine[5].charAt(0));
                            Examination examination = new ThreeOperationsAdder(new OutpatientExamination(),command).getDecoratedExamination();
                            AddExamination(examination, ID_);
                        }
                    }
                    break;
                case "TotalCost":
                    TotalCost(Integer.parseInt(splittedLine[1]));
                    break;
                case "ListPatients":
                    ListPatients();
                    break;
            }
        }
        dao.Update(target_databases[0],target_databases[1]);
        
        String fileName ="output.txt";
        File file = new File(fileName);
        try {
            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(Interface);
            }
        } catch (IOException e) {
        e.printStackTrace();
        }
        dao.Disconnect();
        
    }
    
}
