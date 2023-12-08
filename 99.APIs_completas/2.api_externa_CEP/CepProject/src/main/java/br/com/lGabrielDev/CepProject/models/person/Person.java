package br.com.lGabrielDev.CepProject.models.person;
import br.com.lGabrielDev.CepProject.models.address.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor //constructor sem parametro
@AllArgsConstructor  //constructor com todos os parametros
@Getter
@Setter


@Entity
@Table(name = "tb_person")
public class Person {
    

    //attributes
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @OneToOne(targetEntity = Address.class , cascade = CascadeType.ALL) //criamos a relacao. Sempre que removermos a entidade atual, "Person", o "address" também será removido
    @JoinColumn(name = "address_id", nullable = false, unique = true) //criamos um campo nessa entidade. Esse campo deve ser unico. 1 pessoa nao pode ter o mesmo endereco de outra pessoa
    private Address enderecoCompleto;


    //constructors --> Criados com lombok



    //getters and setters --> Criados com lombok


    //toString() --> Usaremos para debugar
    @Override
    public String toString(){
        return
            String.format(
                "#ID: %d" +
                "Name: %s" +
                "Endereco completo: %s", this.id, this.name, this.enderecoCompleto.toString()
            );
    }
}
