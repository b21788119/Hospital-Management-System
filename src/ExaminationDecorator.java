
public abstract class ExaminationDecorator implements IExamination {
    
    private Examination DecoratedExamination;
    private String command;

    public ExaminationDecorator(Examination Examination, String command) {
        this.DecoratedExamination = Examination;
        this.command = command;
    } 

    public Examination getDecoratedExamination() {
        return DecoratedExamination;
    }

    public void setDecoratedExamination(Examination DecoratedExamination) {
        this.DecoratedExamination = DecoratedExamination;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    abstract void ADD(String command);
    
    
}
