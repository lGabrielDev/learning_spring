package br.com.lGabrielDev.projetinhoFelas.exceptions;
import java.time.LocalDateTime;

public class ErrosPadronizados {
    
    //attributes
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String trace;


    //constructors
    public ErrosPadronizados(){}


    public ErrosPadronizados(LocalDateTime timestamp, Integer status, String error, String trace){
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.trace = trace;
    }


    //getters and setters
    public LocalDateTime getTimestamp(){
        return this.timestamp;
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

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}
