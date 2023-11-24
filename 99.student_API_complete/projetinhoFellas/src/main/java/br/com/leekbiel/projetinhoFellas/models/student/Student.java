package br.com.leekbiel.projetinhoFellas.models.student;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity //transformamos essa class em uma table no banco
@Table(name = "tb_student")
public class Student {
    
    //attributes
    @Id //Esse campo será a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 170, nullable = true)
    private String name;

    @Column(name = "email", length = 170, nullable = true)
    private String email;

    @Column(name = "date_of_birth", nullable = true)
    @DateTimeFormat
    private LocalDate dateOfBirth;

    @Transient // nao queremos mapear esse campo no banco de dados
    private Integer age;


    
    //constructors
    public Student(){}


    public Student(Long id, String name, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }


    public Student(String name, String email, LocalDate dateOfBirth) { //vamos usar esse constructor para criar um Student
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
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
