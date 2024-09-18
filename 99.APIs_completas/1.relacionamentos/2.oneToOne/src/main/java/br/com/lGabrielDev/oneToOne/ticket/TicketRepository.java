package br.com.lGabrielDev.oneToOne.ticket;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    
    //queries
    @Query(value = "SELECT t FROM Ticket t WHERE t.chairNumber = :chair_number")
    public Optional<Ticket> findByChairNumber(@Param("chair_number") Integer chairNumber);
}
