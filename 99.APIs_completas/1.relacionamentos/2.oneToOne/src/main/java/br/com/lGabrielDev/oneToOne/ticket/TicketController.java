package br.com.lGabrielDev.oneToOne.ticket;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.lGabrielDev.oneToOne.ticket.DTOs.TicketCreateDto;
import br.com.lGabrielDev.oneToOne.ticket.DTOs.TicketFullDto;

@RestController
@RequestMapping("/api/v1")
public class TicketController {

    //attributes
    private TicketService ts;

    //constructors
    public TicketController(TicketService ts){
        this.ts = ts;
    }

    // =================== POST ===================
    @PostMapping("/tickets")
    public ResponseEntity<TicketFullDto> createTicket(@RequestBody TicketCreateDto ticketCreateDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ts.createTicket(ticketCreateDto));
    }
    
    // =================== GET ===================
    @GetMapping("/tickets")
    public ResponseEntity<List<TicketFullDto>> getAllTickets(){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ts.getAllTickets());
    }
}
