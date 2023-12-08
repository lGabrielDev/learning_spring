package br.com.lGabrielDev.CepProject.models.person.DTOs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

//usaremos essa class para enviar os dados da "person" que desejamos cadastrar
public class PersonCreateDTO {
    
    //attributes
    private String name;
    private String cep;
   

    //constructors --> Criados pelo lombok

    //getters and setters --> Criados pelo lombok


    //toString() para debugar
    @Override
    public String toString() {
        return
            String.format(
                "Name: %s\n" +
                "CEP: %s", this.name, this.cep
            );
    }
}
