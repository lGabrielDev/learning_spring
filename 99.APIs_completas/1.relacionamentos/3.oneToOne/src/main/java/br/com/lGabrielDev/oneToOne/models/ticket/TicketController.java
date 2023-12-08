package br.com.lGabrielDev.oneToOne.models.ticket;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lGabrielDev.oneToOne.models.person.Person;
import br.com.lGabrielDev.oneToOne.models.person.PersonRepository;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {
    
    //rotas

    //injected attributes
    @Autowired
    private TicketRepository tr;

    @Autowired
    private PersonRepository pr;


    //LIST ALL tickets
    @GetMapping("")
    public List<Ticket> listAll(){
        return tr.findAll();
    }



    //CREATE
    @PostMapping("")
    public Ticket createTicket(@RequestBody(required = true) TicketDtoCreate newTicket){
        
        //os dois campos, "cadeiraNumber" and "owner_id" não podem ser NULL
        if(newTicket.getOwnerId() == null){
            throw new RuntimeException("'Owner #ID' cannot be null!");
        }
        if(newTicket.getCadeiraNumber() == null){
            throw new RuntimeException("Choose your chair number.");
        }


        //verificamos se o owner_id existe no banco
        Optional<Person> pOptional = this.pr.findById(newTicket.getOwnerId());

        if(pOptional.isEmpty()){
            throw new RuntimeException(String.format("Person #%d doesn't existis", newTicket.getOwnerId()));
        }

        Person p1 = pOptional.get();


        //verificamos se o numero da cadeira já pertence a alguem
        Optional<Ticket> tOptional = this.tr.findByChairNumber(newTicket.getCadeiraNumber());

        if(tOptional.isPresent()){
            throw new RuntimeException(String.format("Chair number '%d' was taken. Please, choose another one.", newTicket.getCadeiraNumber()));
        }


        //ultima verificacao... Verificamos se a pessoa já possui algum ticket. 1 pessoa pode ter apenas 1 ticekt
        if(p1.getTicket() != null){
            throw new RuntimeException(String.format("Person #%d already has a ticket", p1.getId()));
        }


        //tudo ok... O dono desse ticket de fato existe no banco E a cadeira está disponível
        //criamos o ticket
        Ticket t1 = new Ticket();
        t1.setNumeroCadeira(newTicket.getCadeiraNumber());
        
        
        //adicionamos nas duas partes da relação - bidirecionamento
        t1.setOwner(p1);  //esse ticket vai receber o "dono tal"
        p1.setTicket(t1); //essa pessoa vai receber o "ticket tal"

        this.tr.save(t1); //salvamos no banco
        this.pr.save(p1); //salvamos no banco
        
        return t1;
    }
}
