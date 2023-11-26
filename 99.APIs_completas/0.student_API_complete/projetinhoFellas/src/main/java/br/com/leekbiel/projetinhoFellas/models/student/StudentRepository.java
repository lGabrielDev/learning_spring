package br.com.leekbiel.projetinhoFellas.models.student;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //Queries

    //==================================== READ ====================================

    //vamos usar polimorfismo
    
    //Find All
    @Query(nativeQuery = false, value = "SELECT s FROM Student s ORDER BY s.id ASC")
    public List<Student> findAll();

    //List All Students with specific "email"
    @Query(nativeQuery = false, value = "SELECT s FROM Student s WHERE s.email LIKE %:email% ORDER BY s.id ASC")
    public List<Student> findAll(@Param(value = "email") String email);

    //List All Students with limited rows
    @Query(nativeQuery = false, value = "SELECT s FROM Student s ORDER BY s.id ASC LIMIT :quantidadeDeRows")
    public List<Student> findAll(@Param(value = "quantidadeDeRows") Integer quantidadeDeRows);

    //List All Students with specific "email" AND with limited rows
    @Query(nativeQuery = false, value = "SELECT s FROM Student s WHERE s.email LIKE %:email% ORDER BY s.id ASC LIMIT :quantidadeDeRows ")
    public List<Student> findAll(@Param(value = "email") String email, @Param(value = "quantidadeDeRows")  Integer quantidadeDeRows);


    
    //Find By #ID
    @Query(nativeQuery = false, value = "SELECT s FROM Student s WHERE s.id = :id")
    public Optional<Student> findById(@Param("id") Long id);

    //Find By "email"
    @Query(nativeQuery = false, value = "SELECT s FROM Student s WHERE s.email = :emailProcurado")
    public Optional<Student> findByEmail(@Param(value = "emailProcurado") String emailProcurado);



    //==================================== DELETE ====================================
    //Delete By #ID
    @Modifying//query sensível. Vamos deletar um registro
    @Query(nativeQuery = false, value = "DELETE FROM Student s WHERE s.id = :id")
    public void deleteById(@Param(value = "id") Long id);



}