package br.com.lGabrielDev.tests_bolados.models.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.tests_bolados.models.Person.dtos.PersonCreateDTO;

@RestController
@RequestMapping("/api")
public class PersonController {

    //injected attributes
    @Autowired
    private PersonService ps;
    
    //rotas
    
    // ================================= READ =================================

    // ============= FindAll =============
    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons(){
        return ResponseEntity.ok().body(this.ps.getAllPersons());
    }


    // ============= findByID =============
    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(this.ps.getPersonById(id));
    }

    // ============= FindByEmail =============
    @GetMapping("/person/by-email/{email}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "email") String email){
        return ResponseEntity.ok().body(this.ps.getPersonByEmail(email));
    }


    // ================================= CREATE =================================
    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody PersonCreateDTO newPerson){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.ps.createPerson(newPerson));
    }


    // ================================= UPDATE =================================
    @PutMapping("/person/{id}")
    public ResponseEntity<Person> createPerson(@PathVariable(value = "id") Long id, @RequestBody PersonCreateDTO dadosNovos){
        return ResponseEntity.status(HttpStatus.OK).body(this.ps.updatePerson(id, dadosNovos));
    }


    // ================================= DELETE =================================
    @DeleteMapping("/person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable(value = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.ps.deletePerson(id));
    }
}