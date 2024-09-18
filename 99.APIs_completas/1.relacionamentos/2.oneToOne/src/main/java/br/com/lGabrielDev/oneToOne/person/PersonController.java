package br.com.lGabrielDev.oneToOne.person;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.oneToOne.person.DTOs.PersonCreateDTO;
import br.com.lGabrielDev.oneToOne.person.DTOs.PersonFullDto;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    //attributes
    private PersonService ps;

    //constructors
    public PersonController(PersonService ps){
        this.ps = ps;
    }
    
    // =================== POST ===================
    @PostMapping("/people")
    public ResponseEntity<PersonFullDto> createPerson(@RequestBody PersonCreateDTO personCreateDTO){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ps.createPerson(personCreateDTO));
    }

    // =================== GET ===================
    @GetMapping("/people")
    public ResponseEntity<List<PersonFullDto>> getAllPeople(){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ps.getAllPeople());
    }
}
