package br.com.empresaTal.spring_praticando.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.empresaTal.spring_praticando.student.DTOs.StudentCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // criamos uma table no banco de dados
@Table(name = "tb_student") // definimos o nome dessa table
public class Student {
    
    //attributes
    @Id //esse campo é a primary key da table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = true) //estamos setando as constraints desse campo
    private String name;

    @Column(name = "email", length = 50, nullable = true)
    private String email;

    @Column(name = "birthday", length = 50, nullable = true)
    private LocalDate birthday;

    //constructors
    public Student(){}
    
    public Student(String name, String email, LocalDate birthday){
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public Student(StudentCreateDTO novoStudent){
        this.name = novoStudent.getName();
        this.email = novoStudent.getEmail();
        this.birthday = novoStudent.getBirthday();
    }

    //getters and setters
    public Long getId(){
        return this.id;
    }

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
    
    public LocalDate getBirthday(){
        return this.birthday;
    }

    public void setBirthday(LocalDate birthday){
        this.birthday = birthday;
    }

    //toString()
    @Override
    public String toString(){
        DateTimeFormatter formatoPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String birthdayFormatado = formatoPadrao.format(this.birthday);

        return
            String.format(
                "#ID: %d\n" +
                "Name: %s\n" +
                "Email: %s\n" +
                "Birthday: %s\n", this.id, this.name, this.email, birthdayFormatado
            );
    }
}
