package br.com.lGabrielDev.projetinhoFelas.models.student;
import java.time.LocalDate;
import java.time.Period;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity //Transformamos essa Class em uma Entity, criando uma table no banco de dados
@Table(name = "tb_student") //definimos o nome da table
public class Student {

    //attributes

    @Id //Esse campo será a PRIMARY KEY da table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 530) //setamos as informacoes do campo --> "Nome do campo" e "VARCHAR"
    private String name;

    @Column(name = "email", length = 420)
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Transient //Esse campo é transitório. Ou seja, não será mapeado no banco de dados. Se quisermos exibir a "idade" do student, chamamos por aqui. Lá no banco, esse campo nao vai existir.
    private Integer age;


    //constructors
    public Student(){}

    public Student(String name, String email, LocalDate dateOfBirth){
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }


    //getters and setter
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
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return this.age;
    }


    //toString()
    @Override
    public String toString(){
        
        //formatando a data para ficar padrao BR
        // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // String dataPadraoBr = dtf.format(this.dateOfBirth);

        return
            String.format(
                "#ID: %d\n" +
                "Name: %s\n" +
                "Email: %s\n" +
                "Date of Birth: %s\n" +
                "Age: %d", this.id, this.name, this.email, this.dateOfBirth, this.getAge()
            );
    }    
}
