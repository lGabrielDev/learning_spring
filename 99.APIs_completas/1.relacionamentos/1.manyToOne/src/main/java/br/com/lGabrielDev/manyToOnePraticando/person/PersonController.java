package br.com.lGabrielDev.manyToOnePraticando.person;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lGabrielDev.manyToOnePraticando.person.DTOs.PersonCreateDto;
import br.com.lGabrielDev.manyToOnePraticando.person.DTOs.PersonFullDTO;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    //attributes
    private PersonService ps;

    //constructors
    public PersonController(PersonService ps){
        this.ps = ps;
    }

    // ============ POST ============
    @PostMapping("/people")
    public ResponseEntity<PersonFullDTO> createPerson(@RequestBody PersonCreateDto personDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ps.createPerson(personDto));
    }

    // ============ GET ============
    @GetMapping("/people")
    public ResponseEntity<List<PersonFullDTO>> createPerson(){
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(this.ps.getAllPeople());
    }
}
