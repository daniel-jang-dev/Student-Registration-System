package sheridan.business;

public class Student implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;

	public enum Program {
        Physics, Mathematics, Chemistry;
    }
    
	private int id = 0;
    private String name = "";
    private String email = "";
    private Program program = Program.Physics;
    private int year = 0;
    private boolean share = false;
    
    public Student(){
        
    }
    
    public Student(StudentForm form){
        
        this.name = form.getName();
        this.email = form.getEmail();
        setProgramName(form.getProgram());
        setYear(form.getYear());
        setShare(form.getShare());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
    
    final public void setProgramName(String program) {
        
        String error = "Illegal program name";
        if(program == null){
            throw new IllegalArgumentException(error);
        }
        
        switch(program){
            case "Physics":
                this.program = Program.Physics;
                break;
            case "Mathematics":
                this.program = Program.Mathematics;
                break;
            case "Chemistry":
                this.program = Program.Chemistry;
                break;  
            default:
                throw new IllegalArgumentException(error);
        }
    }
    
    public String getProgramName(){
        return StudentForm.programs[program.ordinal()];
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    final public void setYear(String year){
    	
        String error = "Illegal year name";
        if(year == null){
            throw new IllegalArgumentException(error);
        }
        switch(year){
            case "First":
                this.year = 1;
                break;
            case "Second":
                this.year = 2;
                break;
            case "Third":
                this.year = 3;
                break;
            default:
                throw new IllegalArgumentException(error);
        }
    }
    
    public String getYearName(){
        return StudentForm.years[year-1];
    }

    public boolean isShared() {
        return share;
    }
    
    public boolean getShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }
    
    final public void setShare(String share){
        String error = "Illegal share value";
        if(share == null){
            throw new IllegalArgumentException(error);
        }
        switch(share){
            case "yes":
            case "1":
                this.share = true;
                break;
            case "no":
            case "0":
                this.share = false;
                break;
            default:
                throw new IllegalArgumentException(error);
        }
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
