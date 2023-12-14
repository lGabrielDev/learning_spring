package br.com.lGabrielDev.tests_bolados.models.Person;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.tests_bolados.exceptions.NameCannotBeNullException;
import br.com.lGabrielDev.tests_bolados.exceptions.PersonNotFoundException;
import br.com.lGabrielDev.tests_bolados.models.Person.dtos.PersonCreateDTO;

@Service
public class PersonService {
    
    //injected attributes
    
    @Autowired
    private PersonRepository pr;


    // ================================= READ =================================

    // ============= FindAll =============
    public List<Person> getAllPersons(){
        return this.pr.findAll();
    }


    // ============= findByID =============
    public Person getPersonById(Long id){
        Optional<Person> pOptional = this.pr.findById(id);

        if(pOptional.isEmpty()){
            throw new PersonNotFoundException("Person not found");
            
        }
        return pOptional.get();
    }
 
    // ============= findByEmail =============
    public Person getPersonByEmail(String email){
        Optional<Person> pOptional = this.pr.findByEmail(email);

        if(pOptional.isEmpty()){
            throw new PersonNotFoundException("Person not found");    
        }
        return pOptional.get();

    }


    // ================================= CREATE =================================
    public Person createPerson(PersonCreateDTO newPerson){
        //validamos se o campo "name" foi inserido
        if(newPerson.getName() == null){
            throw new NameCannotBeNullException("Name nao pode estar em branco");
        }

        Person p1 = new Person();
        p1.setName(newPerson.getName());
        p1.setEmail(newPerson.getEmail());

        return this.pr.save(p1);
    }



    // ================================= UPDATE =================================
    public Person updatePerson(Long id, PersonCreateDTO dadosNovos){
        Optional<Person> pOptional = this.pr.findById(id);

        if(pOptional.isEmpty()){
            throw new PersonNotFoundException("Nao eh possivel alterar, pois nao existe uma pessoa com esse #id");
        }
        
        if(dadosNovos.getName() == null){
            throw new NameCannotBeNullException("Name cannot be null");
        }

        Person p1 = pOptional.get();
        p1.setName(dadosNovos.getName());
        p1.setEmail(dadosNovos.getEmail());
        
        return this.pr.save(p1);
    }


    // ================================= DELETE =================================
    public String deletePerson(Long id){
        Optional<Person> pOptional = this.pr.findById(id);

        if(pOptional.isEmpty()){
            throw new NameCannotBeNullException("Nao eh possivel deletar, pois nao existe uma pessoa com esse #id");
        }

        this.pr.deleteById(id);

        return "Deletado com sucesso!";
    }
}
