package br.com.lGabrielDev.CepProject.models.person;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lGabrielDev.CepProject.models.person.DTOs.PersonCreateDTO;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    //injected attributes
    @Autowired
    private PersonService ps;
    
    // ===================================== CREATE =====================================
    @PostMapping("")
    public ResponseEntity<Person>  createPerson(@RequestBody PersonCreateDTO pessoaEnviadaNoBody){
        return ps.createPerson(pessoaEnviadaNoBody);

    }

    // ===================================== READ ALL =====================================
    @GetMapping("")
    public ResponseEntity<List<Person>> getAllPersons(@RequestParam(value = "uf", required = false) String uf) {
        return ps.getAllPersons(uf); 
    }

}
