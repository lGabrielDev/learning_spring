package br.com.leekbiel.projetinhoFellas.models.student;
import java.util.List;
import org.springframework.http.ResponseEntity;

import br.com.leekbiel.projetinhoFellas.models.student.DTOs.StudentDTOCreate;
import br.com.leekbiel.projetinhoFellas.models.student.DTOs.StudentDTOFull;

public interface StudentServiceImplementations {
    //methods que vamos usar na Studen Service

    //==================================== READ ====================================
    //Find ALl
    public List<StudentDTOFull> StudentList(String email, Integer quantidadeDeRows);

    //Find By #ID
    public StudentDTOFull findById(Long id);


    //==================================== CREATE ====================================
    public ResponseEntity<StudentDTOFull> createStudent(StudentDTOCreate novoStudent);


    //==================================== DELETE ====================================
    public String deleteStudent(Long id);


    //==================================== UPDATE ====================================
    public StudentDTOFull updateStudent(Long id, StudentDTOCreate studentAtualizado);
}
