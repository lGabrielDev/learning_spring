package br.com.lGabrielDev.oneToOne.ticket.validations;

import br.com.lGabrielDev.oneToOne.person.Person;
import br.com.lGabrielDev.oneToOne.person.PersonRepository;
import br.com.lGabrielDev.oneToOne.ticket.Ticket;
import br.com.lGabrielDev.oneToOne.ticket.TicketRepository;

//Os dois campos "cadeiraNumber" and "owner_id" DEVEM ser preenchidos. --> CHECK
// Verificamos se o numero da cadeira já pertence a alguem --> CHECK
// Verificamos se o owner_id existe no banco --> CHECK
// Verificamos se a pessoa já possui algum ticket. 1 pessoa pode ter apenas 1 ticket --> CHECK

public class TicketValidations {

    //costructor
    private TicketValidations(){} 


    //Os dois campos "cadeiraNumber" and "owner_id" DEVEM ser preenchidos. --> CHECK
    public static Boolean chairNumberNotNull(Integer chairNumber){
        if(chairNumber == null){
            throw new RuntimeException("ChairNumber cannot be null");
        }
        return true;
    }

    public static Boolean ownerIdIsNotNull(Long ownerId){
        if(ownerId == null){
            throw new RuntimeException("OwnerId cannot be null");
        }
        return true;
    }

    public static Boolean chairNumberAndOwnerIdAreNotNull(Integer chairNumber, Long ownerId){
        return chairNumberNotNull(chairNumber) && ownerIdIsNotNull(ownerId);
    }

    
    //Verificamos se o numero da cadeira já pertence a alguem
    public static Boolean chairNumberIsFree(Integer chairNumber, TicketRepository tr){
        if(tr.findByChairNumber(chairNumber).isPresent()){

            Ticket tickerCru = tr.findByChairNumber(chairNumber).get();
            throw new RuntimeException(String.format("Ticket #%d com chairNumber %d ja foi preenchido",tickerCru.getId(), tickerCru.getChairNumber()));
        }   
        return true;
    }


    // Verificamos se existe de fato uma pessoa com esse "owner_id" no banco
    public static Boolean ownerIdExists(Long ownerId, PersonRepository pr){
        pr.findById(ownerId).orElseThrow(() -> new RuntimeException(String.format("Person #%d not found!", ownerId)));
        return true;
    }


    // Verificamos se a pessoa já possui algum ticket. 1 pessoa pode ter apenas 1 ticket
    public static Boolean personDoesNotHaveTicketYet(Long ownerId, PersonRepository pr){

        TicketValidations.ownerIdExists(ownerId, pr);
        Person personCru = pr.findById(ownerId).get();

        if(personCru.getTicket() != null){
            throw new RuntimeException(String.format("Person #%d already has ticket #%d", ownerId, personCru.getTicket().getId()));
        }
        return true;
    }
}
