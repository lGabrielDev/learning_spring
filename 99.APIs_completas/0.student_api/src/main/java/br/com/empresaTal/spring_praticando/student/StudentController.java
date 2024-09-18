package br.com.empresaTal.spring_praticando.student;

import java.util.List;
import org.springframework.http.HttpStatus;
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
import br.com.empresaTal.spring_praticando.student.DTOs.StudentCreateDTO;
import br.com.empresaTal.spring_praticando.student.DTOs.StudentFullDTO;
import br.com.empresaTal.spring_praticando.student.DTOs.StudentOnlyNameAndEmailDTO;

@RestController //class controlador rest. É aqui que recebemos os requests http do cliente. Aqui, criamos as rotas.
@RequestMapping("/api/v1") //setamos a url padrão da API
public class StudentController {

    //attributes
    private StudentService ss;

    //constructor
    public StudentController(StudentService ss){
        this.ss = ss;
    }

    // ============= GET =============
    //All students
    @GetMapping("/students")
    public ResponseEntity<List<StudentFullDTO>> getStudents(
        @RequestParam(value = "email_like", required = false) String email,
        @RequestParam(value = "limit_rows", required = false) Integer rows
    )

    {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ss.getStudents(email, rows));
    }


   

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentFullDTO>  getStudentById(@PathVariable Long id){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ss.getStudentById(id));
    }


    @GetMapping("/students/only_name/{id}")
    public ResponseEntity<StudentOnlyNameAndEmailDTO> getStudentOnlyNameAndEmail(@PathVariable("id") Long studentId){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ss.getStudentOnlyNameAndEmail(studentId));
            
    }


    // ============= POST =============
    @PostMapping("/students")
    public ResponseEntity<StudentFullDTO> createStudent(@RequestBody StudentCreateDTO novoStudent){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ss.createStudent(novoStudent));
    }


    // ============= PUT =============
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentFullDTO> updateStudent(@PathVariable("id") Long id, @RequestBody StudentCreateDTO studentAtualizado){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ss.updateStudent(id, studentAtualizado));
    }


    // ============= DELETE =============
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ss.deleteById(id));
    }
}