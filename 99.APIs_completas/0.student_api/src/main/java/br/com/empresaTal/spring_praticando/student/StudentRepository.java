package br.com.empresaTal.spring_praticando.student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    //queries

    // ========= GET =========
    //find all

    //find all, email like
    @Query(value = "SELECT s FROM Student s WHERE s.email LIKE %:email% ORDER BY s.id ASC")
    public List<Student> findAllEmailLike(@Param("email") String email);

    //find all, limit rows
    @Query(value = "SELECT s FROM Student s ORDER BY s.id ASC LIMIT :rows")
    public List<Student> findAllLimitRows(@Param("rows") Integer rows);

    //find all, email like AND limit rows
    @Query(value = "SELECT s FROM Student s WHERE s.email LIKE %:email% ORDER BY s.id ASC LIMIT :rows")
    public List<Student> findAllEmailLikeAndLimitRows(@Param("email") String email, @Param("rows") Integer rows);

    @Query(value = "SELECT s FROM Student s WHERE s.id = :id")
    public Optional<Student> findByIdInsano(@Param("id") Long id);

    @Query(value = "SELECT s FROM Student s WHERE s.email = :email")
    public Optional<Student> findByEmail(@Param("email") String email);




    // ========= POST =========


    
    // ========= PUT =========


    // ========= DELETE =========
}