package br.com.lGabrielDev.projeto.models.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lGabrielDev.projeto.models.person.dtos.PersonCreateDto;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    

    //injected attributes
    @Autowired
    private PersonRepository pr;


    // ============================= READ ============================
    //read all
    public List<Person> getAllPerson(){
        return this.pr.findAll();
    }

    //read all
    public Person getPersonById(Long id){
        Optional<Person> pOptional = this.pr.findById(id);

        if(pOptional.isEmpty()){
            return null;
        }
        
        Person p1 = pOptional.get();
        return p1;
    }


    // ============================= CREATE ============================
    public void createPerson(PersonCreateDto personParaCadastrar){
        Person p1 = new Person(personParaCadastrar);
        this.pr.save(p1);
    }



    // ============================= UPDATE ============================
    public Boolean personIdIsCorrect(Long id){
        Optional<Person> pOptional = this.pr.findById(id);

        if(pOptional.isEmpty()){
            return false;
        }
        return true;
    }



    public Boolean updatePerson(Long id, PersonCreateDto dadosNovos){
        
        Optional<Person> pOptional = this.pr.findById(id);


        //validamos se existe alguma pessoa com o #ID informado
        if(pOptional.isEmpty()){
            return false;
        }

        //alteramos os dados dessa Person by #ID
        Person p1 = pOptional.get();
        p1.setName(dadosNovos.getName());
        p1.setAge(dadosNovos.getAge());

        this.pr.save(p1); //atualizamos esses registro no banco

        return true;
        
    }    




    // ============================= DELETE ============================
    public Boolean deletePersonById(Long id){
        Optional<Person> pOptional = this.pr.findById(id);

        if(pOptional.isEmpty()){
            return false;
        }

        this.pr.deleteById(id);
        return true;
    }

}
