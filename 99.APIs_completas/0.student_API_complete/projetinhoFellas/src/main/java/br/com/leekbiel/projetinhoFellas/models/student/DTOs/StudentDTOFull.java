package br.com.leekbiel.projetinhoFellas.models.student.DTOs;
import java.time.LocalDate;
import java.time.Period;

import br.com.leekbiel.projetinhoFellas.models.student.Student;

public class StudentDTOFull {

    //attributes
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private Integer age;



    //constructors
    public StudentDTOFull(){}

    public StudentDTOFull(Long id, String name, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public StudentDTOFull(String name, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }


    public StudentDTOFull(Student studentParaSerCopiado) {
        this.id = studentParaSerCopiado.getId();
        this.name = studentParaSerCopiado.getName();
        this.email = studentParaSerCopiado.getEmail();
        this.dateOfBirth = studentParaSerCopiado.getDateOfBirth();
        this.age = studentParaSerCopiado.getAge();
    }




    //getters and setters
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        if(this.dateOfBirth == null){
            return null;
        }
        return this.age = Period.between(this.dateOfBirth, LocalDate.now()).getYears();
        
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //toString()
    @Override
    public String toString(){
        return
            String.format(
                "#ID: %d\n" +
                "Name: %s\n" +
                "E-mail: %s\n" +
                "Date of Birth: %s\n" +
                "Age: %d" , this.id, this.name, this.email, this.dateOfBirth, this.getAge() // Usamos o "getAge()" para garantir que a idade venha corretamente
            );
    }

}
