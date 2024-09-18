package br.com.empresaTal.spring_praticando.student.DTOs;

import br.com.empresaTal.spring_praticando.student.Student;

public class StudentOnlyNameAndEmailDTO {

    //attributes
    private String name;
    private String email;

    //constructors
    public StudentOnlyNameAndEmailDTO(){}

    public StudentOnlyNameAndEmailDTO(String name, String email){
        this.name = name;
        this.email = email;
    }

    public StudentOnlyNameAndEmailDTO(Student studentCru){
        this.name = studentCru.getName();
        this.email = studentCru.getEmail();
    }

    //getters and setters
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

    //toString()
}
