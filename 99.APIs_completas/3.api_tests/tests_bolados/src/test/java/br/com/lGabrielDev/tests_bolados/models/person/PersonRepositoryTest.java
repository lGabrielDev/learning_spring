package br.com.lGabrielDev.tests_bolados.models.person;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import br.com.lGabrielDev.tests_bolados.models.Person.Person;
import br.com.lGabrielDev.tests_bolados.models.Person.PersonRepository;

// Essa anntation diz que é uma class de tests para uma repository
// Alem disso, ela configura autmaticamente uma aplication.properties pra nos. Ou seja, configura automaticamente um banco de dados em memory pra nos.
@DataJpaTest
public class PersonRepositoryTest {
    

    //injected attributes
    @Autowired
    private PersonRepository pr; //vamos utilizar os methods dessa Class



    //testando o method findAll()
    @Test
    public void itShouldReturnAListWith2Persons(){
        
        //arrange --> Configuramos tudo que vamos usar
        Person p1 = new Person();
        p1.setName("ben10");
        p1.setEmail("ben10@gmail.com");

        Person p2 = new Person();
        p2.setName("naruto");
        p2.setEmail("narutinho@gmail.com");

        //Salvamos no banco 2 "Persons"
        this.pr.save(p1);
        this.pr.save(p2); 


        //act --> Executamos o methods que queremos testar
        List<Person> methodResult = this.pr.findAll();


        //assert --> Afirmamos o que queremos receber
        Assertions.assertThat(methodResult).isNotNull(); //Afirmamos que a lista não vai ser nula.
        Assertions.assertThat(methodResult).isNotEmpty(); //Afirmamos que a lista não vai estar vazia.
        Assertions.assertThat(methodResult).hasSize(2); //Afirmamos que a lista contem exatamente 2 registros. Afinal, cadastramos exatamente 2 pessoas.
    }



    
    //testando o method findById()
    @Test
    public void itShouldReturnAPersonById(){
        //arrange (organizar tudo que vamos utilizar)
        Person p1 = new Person(
            "sakura",
            "sakuraChan@gmail.com"
        );

        //Como queremos descobrir se o findById() esta funcionando, precisamos antes salvar uma "pessoa" no banco
        this.pr.save(p1);


        //act (Executamos o method que sera testado)
        Person methodResult = this.pr.findById(p1.getId()).get(); 

        //assert (Afirmamos o que vamos receber)
        Assertions.assertThat(methodResult).isNotNull(); //Afirmamos que a method vai retornar uma "Pessoa"
        Assertions.assertThat(methodResult).isEqualTo(p1); //afirmamos que esse method vai retornar a mesma pessoa que foi cadastrada
        Assertions.assertThat(methodResult.getEmail()).isEqualTo(p1.getEmail());
        
    }




    @Test
    public void itShouldNotReturnAPersonByIdBecauseThatPersonDoesntExists(){
        //arrange
        Long personId = 44l;

        //act
        Optional<Person> pOptional = this.pr.findById(personId);


        //assert
        Assertions.assertThat(pOptional.isPresent()).isFalse(); //afirmamos que ao informar um #ID que nao existe, vai será retornado nenhum "pessoa"
    }





    //testando o method findByName()
    @Test
    public void itShouldReturnAPersonByName(){
        //arrange
        Person p1 = new Person(
            "sasuke",
            "uchihaSasuke@gmail.com"
        );

        this.pr.save(p1); //Como queremos testaro findByName(), precisamos salvamos pelo menos 1 registro no banco
        
        //act
        Person methodResult = this.pr.findByName(p1.getName()).get();

        //assert
        Assertions.assertThat(methodResult).isNotNull(); //afirmamos que o method nao vai retornar null.
        Assertions.assertThat(methodResult).isEqualTo(p1); //afirmamos que esse method vai retornar a mesma pessoa que foi cadastrada
    }


    //testando o method findByEmail//testando o method findByName()
    @Test
    public void itShouldReturnAPersonByEmail(){
        //arrange
        Person p1 = new Person(
            "rodolfo",
            "rodo@msn.com"
        );

        this.pr.save(p1); //Salvamos no banco para tentar pegar esse camarada depois

        //act
        Person methodResult = this.pr.findByEmail("rodo@msn.com").get();

        //assert
        Assertions.assertThat(methodResult).isNotNull(); //afirmamos que esse method não vai retornar null
        Assertions.assertThat(methodResult.getEmail()).isEqualTo(p1.getEmail()); //afirmamos que esse method retorna uma Pessoa com o mesmo "email" da pessoa cadastrada
    }

}
