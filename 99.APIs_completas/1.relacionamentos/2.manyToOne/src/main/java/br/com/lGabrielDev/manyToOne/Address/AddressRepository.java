package br.com.lGabrielDev.manyToOne.Address;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
    //queries

    //Find all de todos os addresses que são determinada Person
    
    @Query(nativeQuery = false, value = "SELECT a FROM Address a ORDER BY a.id ASC")
    public List<Address> findAll();

    @Query(nativeQuery = false, value = "SELECT a FROM Address a WHERE a.owner.id = :ownerId")
    public List<Address> findAll(@Param(value = "ownerId") Long ownerId);
}
