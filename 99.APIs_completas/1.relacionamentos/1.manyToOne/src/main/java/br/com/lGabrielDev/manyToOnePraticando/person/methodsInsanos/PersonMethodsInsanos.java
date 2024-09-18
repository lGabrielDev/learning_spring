package br.com.lGabrielDev.manyToOnePraticando.person.methodsInsanos;

import br.com.lGabrielDev.manyToOnePraticando.person.PersonRepository;

public abstract class PersonMethodsInsanos {


    //personId nao pode ser null
    public static Boolean personIdIsNotNull(Long personId){
        
        if(personId == null){
            throw new RuntimeException("OwnerId cannot be null!");
        }
        return true;        
    }



    //verificar se uma pessoa existe no banco, através do seu #ID
    public static Boolean personExists(Long personId, PersonRepository pr){
        
        pr.findById(personId).orElseThrow(() -> new RuntimeException(String.format("Person #%d doesn't exists", personId)));
        return true;
        
    }
}
