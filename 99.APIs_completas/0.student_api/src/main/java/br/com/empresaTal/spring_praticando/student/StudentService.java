package br.com.empresaTal.spring_praticando.student;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.empresaTal.spring_praticando.student.DTOs.StudentCreateDTO;
import br.com.empresaTal.spring_praticando.student.DTOs.StudentFullDTO;
import br.com.empresaTal.spring_praticando.student.DTOs.StudentOnlyNameAndEmailDTO;
import br.com.empresaTal.spring_praticando.student.exception.StudentNotFoundException;
import br.com.empresaTal.spring_praticando.student.validations.emailValidations.EmailValidations;
import br.com.empresaTal.spring_praticando.student.validations.nameValidations.NameValidations;

@Service //essa eh uma service class. Aqui, vamos criar a lógico de negocio e validar os dados
public class StudentService {
    
    //attributes
    private StudentRepository sr;

    //constructor
    public StudentService(StudentRepository sr){
        this.sr = sr;
    }

    // ============= GET =============
    public List<StudentFullDTO> getStudents(String email, Integer rows){

        //pegamos a lista de students, que veio "Crua" do banco
        List<Student> studentsCrus = new ArrayList<>();


        if(email == null || email.isBlank() && rows == null){
            studentsCrus = this.sr.findAll();
        }
        else if(email != null && !(email.isBlank()) && rows != null){
            studentsCrus = this.sr.findAllEmailLikeAndLimitRows(email,rows);
        }
        else if(email == null || email.isBlank() && rows != null){
                studentsCrus = this.sr.findAllLimitRows(rows);
        }
        else{
                studentsCrus = this.sr.findAllEmailLike(email);
        }
        
  
        //precisamos retornar uma lista de "StudentDTOFull"
        List<StudentFullDTO> studentsDtoFull = new ArrayList<>(); //lista que vamos retornar
        
        //para cada student "cru" da lista, vamos criar um student DTO e armazenar na nossa nova lista
        studentsCrus.stream()
        .forEach(studentCru -> {
            StudentFullDTO sdf = new StudentFullDTO(studentCru);
            studentsDtoFull.add(sdf);
        });
        return studentsDtoFull;
    }




    public StudentFullDTO getStudentById(Long studentId){
        
        Student sOptional = this.sr.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException(String.format("Student #%d not found!", studentId)));

       return new StudentFullDTO(sOptional);
    }


    public StudentOnlyNameAndEmailDTO getStudentOnlyNameAndEmail(Long studentId){
        Student studentCru = this.sr.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException(String.format("Student #%d not found!", studentId)));

        return new StudentOnlyNameAndEmailDTO(studentCru);
            
    }






    // ============= POST =============
    public StudentFullDTO createStudent(StudentCreateDTO studentDto){
        
        //name validations
        NameValidations.nameAllValidationsAreCorrect(studentDto.getName());
        
        //email validations...
        
        //birthday validations...


        Student novoStudent = new Student();
        novoStudent.setName(studentDto.getName());
        novoStudent.setEmail(studentDto.getEmail());
        novoStudent.setBirthday(studentDto.getBirthday());

        this.sr.save(novoStudent); //salvamos no banco

        return new StudentFullDTO(novoStudent);
    }


    // ============= UPDATE =============
    public StudentFullDTO updateStudent(Long id, StudentCreateDTO studentAtualizado){
        
        //check if the student exists
        Student novoStudent = this.sr.findById(id)
            .orElseThrow(()-> new StudentNotFoundException(String.format("You cannot update student #%d because it's not exists", id)));

        //name validations
        if(studentAtualizado.getName() != null && !(studentAtualizado.getName().isBlank())){
            NameValidations.nameLengthIsCorrect(studentAtualizado.getName());
            novoStudent.setName(studentAtualizado.getName());
        }
        //email validations
        if(studentAtualizado.getEmail() != null && !(studentAtualizado.getEmail().isBlank())){
            EmailValidations.emailIsUnique(studentAtualizado.getEmail(), this.sr);
            novoStudent.setEmail(studentAtualizado.getEmail());
        }
        //birthday validations
        if(studentAtualizado.getBirthday() != null){
            novoStudent.setBirthday(studentAtualizado.getBirthday());
        }

        this.sr.save(novoStudent); //tudo certo, atualizamos no banco

        return new StudentFullDTO(novoStudent);
    }


    // ============= DELETE =============
    public String deleteById(Long id){
        
        this.sr.findById(id)
            .orElseThrow(()-> new StudentNotFoundException(String.format("You cannot delete student #%d because it's not exists", id)));
    
        this.sr.deleteById(id);

        return String.format("Student #%d was deleted", id);
    }
}