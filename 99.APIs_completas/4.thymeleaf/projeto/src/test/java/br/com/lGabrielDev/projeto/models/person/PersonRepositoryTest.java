package br.com.lGabrielDev.projeto.models.person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest //Class para testar os methods de uma Repository
public class PersonRepositoryTest {
    
    //injected attriutes
    @Autowired
    private PersonRepository pr;



    @Test
    public void itShouldReturnAListOfPersonSucessfully(){
        //arrange
        List<Person> personList = List.of(
            new Person("Amanda", 44),
            new Person("naruto", 44),
            new Person("roberto", 33),
            new Person("carlos", 22)
        );

        personList.stream().forEach( (item) -> this.pr.save(item));

        //act
        List<Person> methodResult = this.pr.findAll();

        //assert
        Assertions.assertThat(methodResult).isNotEmpty();
        Assertions.assertThat(methodResult.size()).isGreaterThan(2);
        Assertions.assertThat(methodResult.get(2).getName()).isEqualTo("roberto");
    }

}
