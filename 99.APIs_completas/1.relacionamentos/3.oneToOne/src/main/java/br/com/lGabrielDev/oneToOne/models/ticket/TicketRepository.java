package br.com.lGabrielDev.oneToOne.models.ticket;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {
    
    //queries
    @Query(nativeQuery = false, value = "SELECT t FROM Ticket t WHERE t.numeroCadeira = :chairNumber")
    public Optional<Ticket> findByChairNumber(@Param(value = "chairNumber") Integer chairNumber);
}
