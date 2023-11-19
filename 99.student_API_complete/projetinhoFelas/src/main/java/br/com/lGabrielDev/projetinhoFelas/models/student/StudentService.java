package br.com.lGabrielDev.projetinhoFelas.models.student;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.projetinhoFelas.exceptions.DateOfBirthCannotBeNull;
import br.com.lGabrielDev.projetinhoFelas.exceptions.EmailAlreadyExists;
import br.com.lGabrielDev.projetinhoFelas.exceptions.EmailCannotBeNull;
import br.com.lGabrielDev.projetinhoFelas.exceptions.NameCannotBeNull;
import br.com.lGabrielDev.projetinhoFelas.exceptions.StudentNotFoundException;

@Service
public class StudentService {

    // injected attributes
    @Autowired
    StudentRepository sr;


    // ========================================== READ ==========================================
    //GET- READ all Student
    public List<Student> getStudents(){
        return this.sr.findAll();
    }



    //READ by #ID
    public Student getStudentById(Long id){
        //verificamos se conseguimos encontrar um Student, ou null
        Optional<Student> sOptional = this.sr.findById(id);

        if(sOptional.isEmpty()){
            throw new StudentNotFoundException(String.format("Student #%d nao encontrado", id)); // usamos a RuntimeException genérica
        }
        return sOptional.get();
    }



    // ========================================== CREATE ==========================================
    public void createStudent(Student novoStudent){
        System.out.println("\n\n\n\n=================================================");
        System.out.println(novoStudent.toString());

        /* Faremos as seguintes validacoes:

         * - field "dateOfBirth" cannot be null
         * - field "name" cannot be null
         * - field "email" cannot be null
         *      - "email" already exists?
         * 
         */
        if(novoStudent.getDateOfBirth() == null){
            throw new DateOfBirthCannotBeNull("The field 'dateOfBirth' cannot be null. You must fill it with something.");
        }

        if(novoStudent.getName() == null){
            throw new NameCannotBeNull("The field 'name' cannot be null. You must fill it with something.");
        }

        if(novoStudent.getEmail() == null){
            throw new EmailCannotBeNull("The field 'email' cannot be null. You must fill it with something.");
        }


        Optional<Student> sOptional = this.sr.findByEmail(novoStudent.getEmail());
        if(sOptional.isPresent()){
            throw new EmailAlreadyExists("'Email' already exists. Choose another one.");
        }
        //salvamos no banco
        this.sr.save(novoStudent);
    }




    // ========================================== DELETE ==========================================
    public void deleteStudent(Long id){
        Optional<Student> sOptional = this.sr.findById(id);

        if(sOptional.isEmpty()){
            throw new StudentNotFoundException(String.format("Student #%d not found", id)); //essa class extends RunTimeException. Poderia ser direto a RuntimeException ou uma class que voce criasse que extendesse RuntimeException
        }
        this.sr.deleteById(id); //deletamos do banco
    }



    // ========================================== UPDATE ==========================================
    public void updateStudent(Long id, Student studentNovo){
        Optional<Student> sOptional = this.sr.findById(id);
        
        //se nao encontrar o #ID do Student, não conseguimos fazer update
        if(sOptional.isEmpty()){
            throw new StudentNotFoundException(String.format("Student #%d not found",id));
        }
       
        //Recuperamos o #ID do student antigo. Assim, garantimos que, ao usar o .save(), vamos apenas alterar o registro e nao criar um novo
        Student studentAntigo = sOptional.get();


        //validando os attributes/campos informados
        /* Se um campo for preenchido, vamos atualizar o campo do Student antigo
        * - campo "dateOfBirth" preenchido, atualizamos o campo antigo
        * - campo "name" preenchido, atualizamos o campo antigo
        * - campo "email" preenchido, verificamos:
        *       - verificamos se o "email" informado já existe.
        *               - Verificamos se o "email" é do próprio student ou se é de outra pessoa
        */

        if(studentNovo.getDateOfBirth() != null){
            studentAntigo.setDateOfBirth(studentNovo.getDateOfBirth());
        }

        if(studentNovo.getName() != null){
            studentAntigo.setName(studentNovo.getName());
        }

        if(studentNovo.getEmail() != null){
            //verificamos se existe no banco algum "Student" com o "email" informado
            Optional<Student> sOptionalEmail = this.sr.findByEmail(studentNovo.getEmail());

            if(sOptionalEmail.isPresent()){
                //verificamos se é o email do proprio student ou se é de outro student
                if(!(studentAntigo.getEmail().equals(studentNovo.getEmail()))){ //se for "email" de outra pessoa
                    throw new EmailAlreadyExists("'E-mail' already exists!");
                }
            }
            //tudo ok, atualizamos o email
            studentAntigo.setEmail(studentNovo.getEmail());
        }
        this.sr.save(studentAntigo); //fazemos o update desse "Student" no banco
    }

}
