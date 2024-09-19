package br.com.lGabrielDev.praticandinho.person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.praticandinho.address.Address;
import br.com.lGabrielDev.praticandinho.person.DTOs.PersonCreateDto;
import br.com.lGabrielDev.praticandinho.person.DTOs.PersonFullDto;

@RestController
@RequestMapping("/api/person")
public class PersonController {


    //attributes
    private PersonService ps;

    //constructors
    public PersonController(PersonService ps){
        this.ps = ps;
    }

    // ====================== POST ======================
    @PostMapping("")
    public ResponseEntity<PersonFullDto> getAddressByCep(@RequestBody PersonCreateDto personCreateDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ps.createPerson(personCreateDto));
    }



    // ====================== GET ======================
    @GetMapping("/{cep}")
    public ResponseEntity<Address> getAddressByCep(@PathVariable("cep") String cep){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ps.getAddressByCep(cep));
    }  
}
