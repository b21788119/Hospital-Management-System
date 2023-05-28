

public class Patient implements HMSComponents{
    
    private String name;
    private String surname;
    private int PatientID;
    private String number;
    private String Address;
    private Admission Admission;

    public Patient(String name, String surname, int PatientID, String number, String Address) {
        this.name = name;
        this.surname = surname;
        this.PatientID = PatientID;
        this.number = number;
        this.Address = Address;
        this.Admission = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int PatientID) {
        this.PatientID = PatientID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress(){
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Admission getAdmission() {
        return Admission;
    }

    public void setAdmission(Admission Admission) {
        this.Admission = Admission;
    }
    public String DatabaseInfo(){
        String info = PatientID+"\t"+name+" "+surname+"\t"+number+"\t"+Address;
        return info;
    }
    @Override
    public String Info() {
        String info = PatientID+" "+name+" "+surname+" "+number+" "+Address;
        return info;
    }

    @Override
    public int TotalCost() {
        return Admission.TotalCost();
    }

    public void AddAdmission(Admission newAdmission){
        Admission = newAdmission;
    }

}
