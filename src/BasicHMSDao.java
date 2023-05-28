
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class BasicHMSDao implements DAO{
    
    private final Reader reader;
    private HMSDataHolder TemporaryConvertedDataHolder;
    
    @Override
    public void Connect(String database) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @Override
    public void Connect(String database1, String database2) {
        String[] PatientInfos = reader.ReadFile(database1);
        String[] AdmissionInfos = reader.ReadFile(database2);
        this.TemporaryConvertedDataHolder = new HMSDataHolder(PatientInfos, AdmissionInfos);
    }

    public BasicHMSDao(Reader reader) {
        this.reader = reader;
        this.TemporaryConvertedDataHolder = null;
    }
    @Override
    public Object getByID(int ID, int command) {
        if(command == 1){
            for(Patient patient:TemporaryConvertedDataHolder.getAllPatients()){
                if(patient.getPatientID()== ID){
                    return patient;
                }
            }
            
        }
        else if(command == 2){
            for(Admission admission : TemporaryConvertedDataHolder.getAllAdmissions()){
                if(admission.getAdmissionID()== ID ){
                    return admission;
                }
            }
        }
        return null;   
    }

    @Override
    public void deleteByID(int ID) {
        ArrayList<Patient> allPatients = TemporaryConvertedDataHolder.getAllPatients();
        ArrayList<Admission> allAdmissions = TemporaryConvertedDataHolder.getAllAdmissions();
        int AdmissionID = 0;
        for(int i=0;i<allPatients.size();i++){
            if(allPatients.get(i).getPatientID() == ID){
                if(allPatients.get(i).getAdmission() != null){
                    AdmissionID = allPatients.get(i).getAdmission().getAdmissionID();
                    allPatients.remove(i);
                }
                else{
                    allPatients.remove(i);
                
                }
            }
        }
        if(AdmissionID != 0){
            for(int j=0;j<allAdmissions.size();j++){
                if(allAdmissions.get(j).getAdmissionID() == AdmissionID){
                    allAdmissions.remove(j);
                }
        
            }
        }
        
        
    }

    @Override
    public void add(Object object) {
        ArrayList<Patient> allPatients = TemporaryConvertedDataHolder.getAllPatients();
        ArrayList<Admission> allAdmissions = TemporaryConvertedDataHolder.getAllAdmissions();
        if(object instanceof Patient){
            allPatients.add((Patient) object);
            Collections.sort(allPatients,Comparator.comparing(Patient:: getPatientID));
        }
        else if(object instanceof Admission){
            int PatientID = ((Admission) object).getPatientID();
            for(Patient patient : allPatients){
                if(patient.getPatientID() == PatientID){
                    patient.AddAdmission(((Admission) object));
                    allAdmissions.add((Admission) object);
                    Collections.sort(allAdmissions,Comparator.comparing(Admission::getAdmissionID));
                }
            }
        } 
    }

    @Override
    public void add(Object object, int ID) {
        ArrayList<Patient> allPatients = TemporaryConvertedDataHolder.getAllPatients();
        ArrayList<Admission> allAdmissions = TemporaryConvertedDataHolder.getAllAdmissions();
        if(object instanceof Examination){
            for(Admission admission : allAdmissions){
                if(admission.getAdmissionID() == ID){
                    admission.AddExamination((Examination) object);
                }
            }  
        }
    }

    @Override
    public ArrayList getALL() {
        ArrayList<Patient> allPatients = TemporaryConvertedDataHolder.getAllPatients();
        
        Collections.sort(allPatients,Comparator.comparing(Patient::getName));
        return allPatients;
    }
    

    @Override
    public void Update(String database1,String database2) {
        ArrayList<Patient> allPatients = TemporaryConvertedDataHolder.getAllPatients();
        ArrayList<Admission> allAdmissions = TemporaryConvertedDataHolder.getAllAdmissions();
        UpdateTool updater = new UpdateTool();
        Collections.sort(allPatients,Comparator.comparing(Patient::getPatientID));
        Collections.sort(allAdmissions,Comparator.comparing(Admission::getAdmissionID));
        updater.CLEAN(database2);
        updater.CLEAN(database1);
        allPatients.forEach((patient) -> {
            updater.WriteContentToDatabase(patient.DatabaseInfo()+"\n",database1);
        });
        allAdmissions.forEach((admission) -> {
            updater.WriteContentToDatabase(admission.Info(),database2);
        });        
        
}
    @Override
    public void Update(String database) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void Disconnect() {
        this.TemporaryConvertedDataHolder = null;
    }
    
    
    
    
    
    
    
}
    
