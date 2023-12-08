package br.com.lGabrielDev.oneToOne.models.person;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    //injected attributes
    @Autowired
    private PersonRepository pr;

    //rotas

    //LIST ALL persons
    @GetMapping("")
    public List<Person> listAll(){
        return this.pr.findAll();
    }


    //CREATE a person
    @PostMapping("")
    public Person createPerson(@RequestBody(required = true) PersonDTOCreate newPerson){
        
        //verificamos se foi passado um "name"
        if(newPerson.getName() == null){
            throw new RuntimeException("'Person name' cannot be null!\n");
        }

        //criamos a "person crua" para salvar no banco
        Person p1 = new Person(newPerson);
        return this.pr.save(p1); 
    }


    //DELETE a person
    @DeleteMapping("{personId}")
    public String deletePerson(@PathVariable(value = "personId") Long personId){
        
        Optional<Person> pOptional = this.pr.findById(personId);

        if(pOptional.isEmpty()){
            throw new RuntimeException(String.format("Person #%d not found...", personId));
        }

        this.pr.deleteById(personId); //deletamos do banco
        return "Successfully deleted!";
    }

}
