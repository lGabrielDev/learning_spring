package br.com.empresaTal.spring_praticando.student.DTOs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentCreateDTO {
    //attributes
    private String name;
    private String email;
    private LocalDate birthday;

    //constructors
    public StudentCreateDTO(){};

    public StudentCreateDTO(String name, String email, LocalDate birthday){
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    };

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

    public LocalDate getBirthday() {
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // return dtf.format(this.birthday);
        return this.birthday;
    }

    public String getBirthdayAsString() {
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
                "Name: %s\n" +
                "Email: %s\n" +
                "Birthday: %s", this.name, this.email, this.birthday
            );
    }
}
