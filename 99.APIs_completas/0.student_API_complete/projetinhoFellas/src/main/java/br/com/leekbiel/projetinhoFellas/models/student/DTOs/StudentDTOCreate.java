package br.com.leekbiel.projetinhoFellas.models.student.DTOs;

import java.time.LocalDate;

import br.com.leekbiel.projetinhoFellas.models.student.Student;

public class StudentDTOCreate { //aqui, nao precisamos passar o id nem a idade do aluno. Afinal, só queremos cadastrar o Student.
    
    //attributes
    private String name;
    private String email;
    private LocalDate dateOfBirth;



    //constructors
    public StudentDTOCreate(){}

    public StudentDTOCreate(String name, String email, LocalDate dateOfBirth){
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }


    public StudentDTOCreate(Student studentParaSerCopiado){
        this.name = studentParaSerCopiado.getName();
        this.email = studentParaSerCopiado.getEmail();
        this.dateOfBirth = studentParaSerCopiado.getDateOfBirth();
    }

    

    //getters and setters
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    //toString()
    @Override
    public String toString(){
        return
            String.format(
                "Name: %s\n" +
                "E-mail: %s\n" +
                "Date of Birth: %s\n", this.name, this.email, this.dateOfBirth
            );
    }

    
}
