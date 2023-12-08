package br.com.lGabrielDev.CepProject.errors;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

//vamos utilizar essa Class para representar o objeto enviado no body da resposta HTTP (ResponseEntity<>)
public class EstruturaErroPadrao {
    


    //attributes
    private LocalDateTime timestamp;
    private Integer status;
    private String errorMessage;


    //constructors --> Criados pelo lombok


    //getters and setters --> Criados pelo lombok
    public String getTimestamp(){
        String dateFormatadinha =  DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm:ss a").format(this.timestamp);
        return dateFormatadinha;
            
    }

}


