package br.com.lGabrielDev.projeto.models.person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
    //queries
    
    // ============================= READ ============================
    @Query(nativeQuery = false, value = "SELECT p FROM Person p ORDER BY p.id ASC")
    public List<Person> findAll();
}
