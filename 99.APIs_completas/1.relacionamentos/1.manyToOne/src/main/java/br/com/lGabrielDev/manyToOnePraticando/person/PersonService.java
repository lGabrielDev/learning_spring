package br.com.lGabrielDev.manyToOnePraticando.person;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.manyToOnePraticando.person.DTOs.PersonCreateDto;
import br.com.lGabrielDev.manyToOnePraticando.person.DTOs.PersonFullDTO;

@Service
public class PersonService {
    
    //attributes
    private PersonRepository pr;

    //constructors
    public PersonService(PersonRepository pr){
        this.pr = pr;
    }

    // ============ POST ============
    public PersonFullDTO createPerson(PersonCreateDto personCreateDto){
        
        //algumas validacoes se quiséssemos....
        
        Person personCru = new Person(personCreateDto);
        this.pr.save(personCru); //salvamos no banco
        return new PersonFullDTO(personCru);
    }
    

    // ============ GET ============
    public List<PersonFullDTO> getAllPeople(){
        
        List<PersonFullDTO> peopleDtoList = new ArrayList<>();

        this.pr.findAll().stream()
            .forEach((peopleCrua) -> {
                peopleDtoList.add(new PersonFullDTO(peopleCrua));
            });
        return peopleDtoList;
    }
}
