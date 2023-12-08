package br.com.lGabrielDev.manyToOne.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    //CREATE
    @PostMapping("")
    public Person createPerson(@RequestBody(required = true) Person newPerson){
        return this.pr.save(newPerson);
    }


    //READ All
    @GetMapping("")
    public List<PersonDTOFull> getAllPersons(){
        return PersonDTOFull.converterAddress(this.pr.findAll());
    }
}
