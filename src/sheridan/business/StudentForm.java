package sheridan.business;

public class StudentForm implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String name = "";
    private String email = "";
    private String program = "";
    private String year = "";
    private String share = "";
    
    final static String[] programs = {"Physics", "Mathematics", "Chemistry"};
    
    final static String[] years = {"First", "Second", "Third"};
    
    public String[] getAllPrograms(){
        return programs;
    }
    
    public String[] getAllYears(){
        return years;
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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }
    
}
