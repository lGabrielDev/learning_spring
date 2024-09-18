package br.com.lGabrielDev.oneToOne.person;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.oneToOne.person.DTOs.PersonCreateDTO;
import br.com.lGabrielDev.oneToOne.person.DTOs.PersonFullDto;
import br.com.lGabrielDev.oneToOne.person.validations.PersonMethodsLegais;

@Service
public class PersonService {

    //attributes
    private PersonRepository pr;

    //constructors
    public PersonService(PersonRepository pr){
        this.pr = pr;
    }
    
    // =================== POST ===================
    public PersonFullDto createPerson(PersonCreateDTO personCreateDTO){

        //verificamos se o o "name" foi preenchido
        PersonMethodsLegais.nameIsNotNull(personCreateDTO.getName());

        Person personCrua = new Person(personCreateDTO);
        this.pr.save(personCrua); //salvamos no banco

        return new PersonFullDto(personCrua);
    }

    // =================== GET ===================
    public List<PersonFullDto> getAllPeople(){
        List<PersonFullDto> personDtoList = new ArrayList<>();

        this.pr.findAll().stream().forEach((personCru) -> {
                PersonFullDto personDto = new PersonFullDto(personCru);
                personDtoList.add(personDto);
            });
        return personDtoList;
    }
}