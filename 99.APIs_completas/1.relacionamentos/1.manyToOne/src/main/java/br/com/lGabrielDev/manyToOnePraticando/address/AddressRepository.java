package br.com.lGabrielDev.manyToOnePraticando.address;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    
    //queries
    @Query(value = "SELECT a FROM Address a WHERE a.owner.id = :owner_id ORDER BY a.id ASC")
    public List<Address> findAll(@Param("owner_id") Long ownerId);
}
