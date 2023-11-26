package br.com.lGabrielDev.manyToMany.exceptions;

import java.time.LocalDateTime;

public class ErroPadrao {
    
    //attributes
    private LocalDateTime timestamp;
    private Integer status;
    private String error;

    //constructor
    public ErroPadrao(LocalDateTime timestamp, Integer status, String error){
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }



    //getters and setters

    public LocalDateTime getTimestamp() {
        return timestamp;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    

}
