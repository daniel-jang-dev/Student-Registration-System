package sheridan.business;

import java.util.*;

public class StudentFormValidator {
    
    public static List<String> validate(StudentForm form){
        
        List<String> errors = new ArrayList<>();
        
        if(form.getName() == null || form.getName().trim().isEmpty()){
            errors.add("No name value");
        }
        
        if(form.getEmail() == null || form.getEmail().trim().isEmpty()){
            errors.add("No email value");
        }
        
        if(form.getYear() != null){
            boolean found = false;
            for(String year : StudentForm.years){
                if(year.equals(form.getYear())){
                    found = true;
                    break;
                }
            }
            if(!found){
                errors.add("Illegal year selection");
            }
        }else{
            errors.add("No year selection");
        }
        
        if(form.getProgram() != null){
            boolean found = false;
            for(String program : StudentForm.programs){
                if(program.equals(form.getProgram())){
                    found = true;
                    break;
                }
            }
            if(!found){
                errors.add("Illegal program name");
            }
        }else{
            errors.add("No program name");
        }
        
        if(!(form.getShare().equals("yes")|| form.getShare().equals("no"))){
            errors.add("Illegal information share selection");
        }
        return errors;
    }
}
