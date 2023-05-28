
public class Main {
    public static void main(String[] args){
        String input = args[0];
        BasicHMSDao dao = new BasicHMSDao(new Reader());
        String[] inputData = new Reader().ReadFile(input);
        HMS HMS = new HMS(dao,"patient.txt","admission.txt");
        HMS.RUN(inputData);
    }
}
