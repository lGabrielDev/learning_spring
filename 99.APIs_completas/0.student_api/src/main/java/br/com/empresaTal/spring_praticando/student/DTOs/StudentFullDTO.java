package br.com.empresaTal.spring_praticando.student.DTOs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.empresaTal.spring_praticando.student.Student;

public class StudentFullDTO {
    //attributes
    private Long id;
    private String name;
    private String email;
    private LocalDate birthday;

    //constructors
    public StudentFullDTO(Student studentPadrao){
        this.id = studentPadrao.getId();
        this.name = studentPadrao.getName();
        this.email = studentPadrao.getEmail();
        this.birthday = studentPadrao.getBirthday();
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

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public String birthdayAsString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dtf.format(this.birthday);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    //toString()
    @Override
    public String toString() {
        return
            String.format(
                "#ID: %d\n" +
                "Name: %s\n" +
                "Email: %s\n" +
                "Birthday: %s", this.id, this.name, this.email, this.birthday
            );
    }

  
}
