package br.com.lGabrielDev.oneToOne.ticket;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.lGabrielDev.oneToOne.person.Person;
import br.com.lGabrielDev.oneToOne.person.PersonRepository;
import br.com.lGabrielDev.oneToOne.ticket.DTOs.TicketCreateDto;
import br.com.lGabrielDev.oneToOne.ticket.DTOs.TicketFullDto;
import br.com.lGabrielDev.oneToOne.ticket.validations.TicketValidations;

@Service
public class TicketService {
    
    //attributes
    private TicketRepository tr;
    private PersonRepository pr;

    //constructors
    public TicketService(TicketRepository tr, PersonRepository pr){
        this.tr = tr;
        this.pr = pr;
    }

    // =================== POST ===================
    public TicketFullDto createTicket(TicketCreateDto ticketCreateDto){

        //pegamos os dados informados no @RequestBody
        Integer chairNumber = ticketCreateDto.getChairNumber();
        Long ownerId = ticketCreateDto.getOwnerId();

        //validacoes
        TicketValidations.chairNumberAndOwnerIdAreNotNull(chairNumber, ownerId);
        TicketValidations.chairNumberIsFree(chairNumber, this.tr);
        TicketValidations.ownerIdExists(ownerId, pr);
        TicketValidations.personDoesNotHaveTicketYet(ownerId, pr);

        Person personCru = this.pr.findById(ownerId).get();

        Ticket ticketCru = new Ticket();
        ticketCru.setChairNumber(ticketCreateDto.getChairNumber());
        
        //bilateralidade
        ticketCru.setOwner(personCru);
        personCru.setTicket(ticketCru);

        //salvamos no banco
        this.tr.save(ticketCru);
        this.pr.save(personCru);
        
        return new TicketFullDto(ticketCru);
    }


    // =================== GET ===================
    public List<TicketFullDto> getAllTickets(){
        List<TicketFullDto> ticketDtoList = new ArrayList<>();

        this.tr.findAll().stream().forEach((ticketCru) -> {
            ticketDtoList.add(new TicketFullDto(ticketCru));
        });

        return ticketDtoList;
    }
}
