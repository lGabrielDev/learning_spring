package br.com.lGabrielDev.projetinhoFelas.models.student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    //queries

    // ========================================== READ ==========================================
    //findAll
    @Query(nativeQuery = false, value = "SELECT s FROM Student s ORDER BY s.id ASC")
    public List<Student> findAll();


    //findById
    @Query(nativeQuery = false, value = "SELECT s FROM Student s WHERE s.id = :id")
    public Optional<Student> findById(@Param("id") Long id);


    //FindByEmail
    @Query(value = "SELECT s FROM Student s WHERE s.email = :emailProcurado")
    public Optional<Student> findByEmail(@Param("emailProcurado") String emailProcurado);



    // ========================================== DELETE ==========================================
    @Modifying // Estamos dizendo que essa query é sensível, pois vamos modificar um registro. No caso de update ou delete de um registro
    @Query(nativeQuery = false,value = "DELETE FROM Student s WHERE s.id = :id")
    public void deleteById(@Param("id") Long id);

    

    
    // ========================================== DELETE ==========================================

}
