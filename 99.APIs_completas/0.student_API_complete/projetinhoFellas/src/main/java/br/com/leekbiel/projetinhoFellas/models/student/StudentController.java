package br.com.leekbiel.projetinhoFellas.models.student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.leekbiel.projetinhoFellas.models.student.DTOs.StudentDTOCreate;
import br.com.leekbiel.projetinhoFellas.models.student.DTOs.StudentDTOFull;

@RestController // essa class é responsável em controlar/criar rotas
@RequestMapping(path = "/api")
public class StudentController {

    //attributes injetados
    @Autowired //injetamos esse attribute para conseguir usar seus methods.
    private StudentService ss;


    //==================================== READ ====================================
    //Find All
    @GetMapping("/students")
    public List<StudentDTOFull> findAll(
        @RequestParam(value = "email", required = false) String email,
        @RequestParam(value = "rows", required = false) Integer quantidadeDeRows)
        
    {
        return this.ss.StudentList(email, quantidadeDeRows);
    }

  
    //Find By #ID
    @GetMapping("/students/{id}")
    public StudentDTOFull findById(@PathVariable(value = "id") Long id){
        return this.ss.findById(id);
    }



    //==================================== CREATE ====================================
    @PostMapping("/students")
    public ResponseEntity<StudentDTOFull> createStudent(@RequestBody StudentDTOCreate novoStudent){
        return this.ss.createStudent(novoStudent);
    }



    //==================================== DELETE ====================================
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable(value = "id") Long id){
        return this.ss.deleteStudent(id);
    }



    //==================================== UPDATE ====================================
    @PutMapping("/students/{id}")
    public StudentDTOFull updateStudent(@PathVariable(value = "id") Long id, @RequestBody StudentDTOCreate studentAtualizado){
        return this.ss.updateStudent(id, studentAtualizado);
    }
}
