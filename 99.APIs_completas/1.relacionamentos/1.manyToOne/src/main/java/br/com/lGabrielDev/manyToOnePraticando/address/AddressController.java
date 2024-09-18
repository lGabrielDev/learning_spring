package br.com.lGabrielDev.manyToOnePraticando.address;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.manyToOnePraticando.address.DTOs.AddressCreateDTO;
import br.com.lGabrielDev.manyToOnePraticando.address.DTOs.AddressFullDtoOwnerId;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
    
    //attributes
    private AddressService as;

    //constructors
    public AddressController(AddressService as){
        this.as = as;
    }

    // ============ POST ============
    @PostMapping("/addresses")
    public ResponseEntity<AddressFullDtoOwnerId> createAddress(@RequestBody AddressCreateDTO addressDto){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.as.createAddress(addressDto));  
    }

    // ============ GET ============
    @GetMapping("/addresses")
    public ResponseEntity<List<AddressFullDtoOwnerId>> getAllAddresses(
        @RequestParam(value = "owner_id", required = false) Long ownerId
    )
    {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.as.getAllAddresses(ownerId));  
    }
}
