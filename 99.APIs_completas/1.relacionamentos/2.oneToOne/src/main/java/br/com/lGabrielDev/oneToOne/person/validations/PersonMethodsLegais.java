package br.com.lGabrielDev.oneToOne.person.validations;

public abstract class PersonMethodsLegais {
    
    //verificar se o campo "name" foi preenchido
    public static Boolean nameIsNotNull(String name){
        if(name == null || name.isBlank()){
            throw new RuntimeException("'name' cannot be null");
        }
        return true;
    }
}
