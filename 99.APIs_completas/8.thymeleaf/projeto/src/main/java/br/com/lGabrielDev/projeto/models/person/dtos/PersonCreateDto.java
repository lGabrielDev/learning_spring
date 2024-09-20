package br.com.lGabrielDev.projeto.models.person.dtos;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonCreateDto {
    
    //attributes
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 10,message = "Too much characters")
    private String name;


    @NotNull(message = "Age cannot be null")
    @Min(value = 18, message = "Age must be bigger than 18")
    private Integer age;

    //constructors
    public PersonCreateDto(){}

    public PersonCreateDto(String name, Integer age){
        this.name = name;
        this.age = age;
    }


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

   
    //toString() para debugar
    @Override
    public String toString() {
        return
            String.format(
                "Name: %s\n" +
                "Age: %d", this.name , this.age
            );
    }
}
