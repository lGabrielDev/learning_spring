package br.com.empresaTal.spring_praticando.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErroPadrao {
    
    //attributes
    private LocalDateTime timestamp;
    private Integer status;
    private String errorMessage;
    private String trace;

    //constructor
    public ErroPadrao(){}

    public ErroPadrao(LocalDateTime timestamp, Integer status, String errorMessage, String trace){
        this.timestamp = timestamp;
        this.status = status;
        this.errorMessage = errorMessage;
        this.trace = trace;
    }

    //getters and setters    
    public String getTimestamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dtf.format(this.timestamp);
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    //toString
    @Override
    public String toString(){
        
        return String.format(
            "timestamp: %s\n" +
            "status: %s\n" +
            "errorMessage: %s\n" +
            "trace: %s\n", this.timestamp, this.status, this.errorMessage, this.trace
        );
    }
}
