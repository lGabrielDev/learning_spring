package br.com.leekbiel.projetinhoFellas.models.student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.leekbiel.projetinhoFellas.exceptions.DateOfBirthCannotBeNullException;
import br.com.leekbiel.projetinhoFellas.exceptions.EmailAlreadyExistsException;
import br.com.leekbiel.projetinhoFellas.exceptions.EmailCannotBeNullException;
import br.com.leekbiel.projetinhoFellas.exceptions.NameCannotBeNullException;
import br.com.leekbiel.projetinhoFellas.exceptions.StudentNotFoundException;
import br.com.leekbiel.projetinhoFellas.models.student.DTOs.StudentDTOCreate;
import br.com.leekbiel.projetinhoFellas.models.student.DTOs.StudentDTOFull;

@Service
public class StudentService implements StudentServiceImplementations{

    //attributes injetados
    @Autowired //injetamos esse attribute para conseguir usar seus methods
    private StudentRepository sr;



    //==================================== READ ====================================

    //Find All
    @Override
    public List<StudentDTOFull> StudentList(String email, Integer quantidadeDeRows){ //vamos retonar uma lista de StudentsDTO

        //Apenas criamos a lista
        List<Student> studentsCrus = new ArrayList<>();

        //dependendo dos parametros informados, buscamos a lista de Students ideal

        //List All Students
        if(email == null && quantidadeDeRows == null){
            studentsCrus = this.sr.findAll();
        }
        //List Students with specific "email"
        else if(email != null && quantidadeDeRows == null){
            studentsCrus = this.sr.findAll(email);
        }
        //List Students, with limited rows
        else if(email == null && quantidadeDeRows != null){
            studentsCrus = this.sr.findAll(quantidadeDeRows);
        }
        //List Students with specific "email" AND with limited rows
        else if(email != null && quantidadeDeRows != null){
            studentsCrus = this.sr.findAll(email, quantidadeDeRows);
        }


        //precisamos retornar uma lista de "StudentDTOFull"
        List<StudentDTOFull> listStudentsDTOs = new ArrayList<>();

        //para cada student "cru" da lista, vamos criar um student DTO e armazenar na nossa nova lista
        for(Student i : studentsCrus){
            StudentDTOFull s1 = new StudentDTOFull(
                i.getId(),
                i.getName(),
                i.getEmail(),
                i.getDateOfBirth()
            );
            listStudentsDTOs.add(s1);
        }
        return listStudentsDTOs; 
    }
        



    //Find By #ID
    @Override
    public StudentDTOFull findById(Long id){

        //verificamos se existe de fato um registor com esse #ID
        Optional<Student> sOptional = this.sr.findById(id);

        if(sOptional.isEmpty()){
            throw new StudentNotFoundException(String.format("Student #%d doesn't exists", id));
        }

        //pegamos um student "Cru" direto do banco
        Student studentCru = sOptional.get();

        //criamos um DTOzinho para enviar
        StudentDTOFull s1 = new StudentDTOFull(studentCru);
        return s1;
    }



    //==================================== CREATE ====================================
    @Override
    public ResponseEntity<StudentDTOFull> createStudent(StudentDTOCreate novoStudent) {
        
        //validamos esse Student recebido no body. Vamos fazer as seguintes validacoes:
        /*
            *  - "name" cannot be null
            *  - "dateOfBirth" cannot be null
            *  - "email" cannot be null
            *      - "email" cannot be duplicated
        */

        //os campos DEVEM ser preenchidos
        if(novoStudent.getName() == null){
            throw new NameCannotBeNullException("The fild 'name' cannot be empty");
        }

        if(novoStudent.getDateOfBirth() == null){
            throw new DateOfBirthCannotBeNullException("The fild 'dateOfBirth' cannot be empty");
        }

        if(novoStudent.getEmail() == null){
            throw new EmailCannotBeNullException("The field 'email' cannot be null");
        }

        //verificamos se o "email" já existe
        Optional<Student> sOptional1 = this.sr.findByEmail(novoStudent.getEmail());
        
        if(sOptional1.isPresent()){
            throw new EmailAlreadyExistsException("Email already registered. Please, choose another one.");
        }


        //criamos um student com os dados todos validados e bonitinhos para salvar no banco
        Student studentComDadosCorretos = new Student(
            novoStudent.getName(),
            novoStudent.getEmail(),
            novoStudent.getDateOfBirth()
        );

        //salvamos no banco
        this.sr.save(studentComDadosCorretos);


        //Agora, precisamos retornar um DTOFULL com todos os attributes
        //Como acabamos de cadastrar um "Student", vamos usar email passado, já que ele é ÚNICO, para pegar essas informacoes
        Optional<Student> sOptional2 = this.sr.findByEmail(studentComDadosCorretos.getEmail());

        
        StudentDTOFull studentCadastrado = new StudentDTOFull(
            sOptional2.get()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(studentCadastrado);

    }



    //==================================== DELETE ====================================

    @Override
    public String deleteStudent(Long id) {
        //Antes de deletar, verificamos se existe um Student com o #ID informado
        Optional<Student> sOptional = this.sr.findById(id);

        if(sOptional.isEmpty()){
            throw new StudentNotFoundException(String.format("Student #%d doesn't exists", id));
        }

        this.sr.deleteById(id); //deletamos do banco

        return String.format("Student #%d was deleted successfully!", id);
    }


   


    //==================================== UPDATE ====================================
    @Override
    public StudentDTOFull updateStudent(Long id, StudentDTOCreate studentAtualizado) {
        
        
        //Antes de atualizar um registro, precisamos saber se de fato existe um registro com o #ID informado
        Optional<Student> sOptional = this.sr.findById(id);

        if(sOptional.isEmpty()){
            throw new StudentNotFoundException(String.format("Student #%d doesn't exists", id));
        }

        //criamos um "Student cru" para pegar o #ID. Assim, conseguimos fazer o update dele, ao invés de criar um novo registro
        Student studentCru = sOptional.get();

        //fazemos as seguintes validacoes:
        /*
         *  - Se o campo "name" for preenchido, atualizamos esse campo
         *  - Se o campo "dateOfBirth" for preenchido, atualizamos esse campo
         *  - Se o campo "email" for preenchido, atualizamos esse campo
         *      - Verificamos se o "email" informado já existe no banco
         *          - Esse email é do prórprio Student?? Se sim, safe.
        */

        if(studentAtualizado.getName() != null){
            studentCru.setName(studentAtualizado.getName());
        }
        if(studentAtualizado.getDateOfBirth() != null){
            studentCru.setDateOfBirth(studentAtualizado.getDateOfBirth());
        }
        if(studentAtualizado.getEmail() != null){
            //verificamos se o "email" informado ja existe no banco
            Optional<Student> studentEmailJaExiste = this.sr.findByEmail(studentAtualizado.getEmail());

            if(studentEmailJaExiste.isPresent()){
                //verificamos se é do próprio Student ou se é de outra pessoa
                if(!(studentCru.getEmail().equals(studentAtualizado.getEmail()))){
                    throw new EmailAlreadyExistsException("Email already registered. Please, choose another one.");
                }
            }
            //tudo ok, atualizamo o email
            studentCru.setEmail(studentAtualizado.getEmail());
        }


        //atualizamos no banco
        this.sr.save(studentCru);

        //retornamos um DTOzinho
        StudentDTOFull studentAtualizadoComSucesso = new StudentDTOFull(studentCru);
        return studentAtualizadoComSucesso;
    }

}
