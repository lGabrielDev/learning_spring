package br.com.lGabrielDev.projetinhoFelas.models.student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Essa class é uma class controladora, que retorna objetos JSON
@RequestMapping(path = "/api/v1/") //setamos a rota padrao. Nesse caso http://localhost:8080/api/v1/
public class StudentController{

    //attributes injetados
    @Autowired
    private StudentService ss;


    // ========================================== READ ==========================================

    //READ ALL STUDENTS
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return this.ss.getStudents();
    }

    //READ Student by #ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return ss.getStudentById(id);
    }


    // ========================================== CREATE ==========================================
    @PostMapping("/students")
    public void createStudent(@RequestBody Student s1){ //vamos informar esse "Student" no body da requisicao
        this.ss.createStudent(s1);
    }



    // ========================================== DELETE ==========================================
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        this.ss.deleteStudent(id);
    }


    // ========================================== UPDATE ==========================================
    @PutMapping("/students/{id}")
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Student studentNovo){
        this.ss.updateStudent(id, studentNovo);
    }

}