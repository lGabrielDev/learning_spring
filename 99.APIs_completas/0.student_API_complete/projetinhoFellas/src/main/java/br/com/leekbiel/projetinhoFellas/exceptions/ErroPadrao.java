package br.com.leekbiel.projetinhoFellas.exceptions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErroPadrao { //essa Class vai conter os 4 attributes que nos aparece quando uma exception em uma resposta HTTP
    //attributes
    private LocalDateTime timestamp;
    private Integer status;
    private String error;

    //constructors
    public ErroPadrao(){}

    public ErroPadrao(LocalDateTime timestamp, Integer status, String error){
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    //getters and setters
    public String getTimestamp(){
        //formatando a date para mais legibilidade
        DateTimeFormatter formatacaoPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm:ss");
        String dataFormatada = formatacaoPadrao.format(this.timestamp);

        return dataFormatada;
    }

    public void setTimestamp(LocalDateTime timestamp){
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    // toString()
    @Override
    public String toString(){
        //formatando a date para mais legibilidade
        DateTimeFormatter formatacaoPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm:ss");
        String dateFormatada = formatacaoPadrao.format(this.timestamp);
        
        return
            String.format(
                "timestamp: %s\n" +
                "status: %d\n" +
                "error: %s\n", dateFormatada, this.status,this.error);
    }
    
}
