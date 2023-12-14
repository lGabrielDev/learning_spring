package br.com.lGabrielDev.tests_bolados.models.person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.lGabrielDev.tests_bolados.exceptions.NameCannotBeNullException;
import br.com.lGabrielDev.tests_bolados.models.Person.Person;
import br.com.lGabrielDev.tests_bolados.models.Person.PersonRepository;
import br.com.lGabrielDev.tests_bolados.models.Person.PersonService;
import br.com.lGabrielDev.tests_bolados.models.Person.dtos.PersonCreateDTO;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class) //informamos que essa class de test vai utilizar "mocks"
public class PersonServiceTest {


    //informamos a class dos methods que vamos testar
    @InjectMocks //injetamos todos os "mocks" para a class que vamos testar os methods. Assim, todos os methods que não sejam da Service Class serão "mockados"/fingidos por nós.
    private PersonService ps;


    //informamos os "mocks" que vao ser injetados na class dos methods que serao testados
    @Mock //todos os methods da class "PersonRepository" serão "mockados"/fingidos. Ou seja, nós que vamos decidir oque esses methods farao
    private PersonRepository pr;



    //tests

    // ================================= READ =================================
    // ============= FindAll =============
    @Test
    public void itShouldReturnsAListOfPersons(){
        //arrange
        Person p1 = new Person("Naruto", "narutinho@gmail.com");
        Person p2 = new Person("Sasuke", "uchiha@gmail.com");

        List<Person> persons = Arrays.asList(p1,p2);


        //informamos como os methods mockados devem se comportar
        Mockito.when(this.pr.findAll()).thenReturn(persons);


        //act
        List<Person> methodResult = this.ps.getAllPersons();

        //assert
        Assertions.assertThat(methodResult).hasSize(2); //afirmamos que essa lista tera 2 pessoas
        Assertions.assertThat(methodResult).isNotEmpty(); //afirmamos que essa lista nao esta vazia
        Assertions.assertThat(methodResult).containsExactly(p1,p2); //afirmamos que essa lista vai conter exatamente a "p1" e "p2"
    }


    // ============= findByID =============
    @Test
    public void itShouldReturnAPersonById(){
        
        //arrange
        Person p1 = new Person("Naruto", "narutinho@gmail.com");
        Optional<Person> pOptional = Optional.of(p1);
        Long idProcurado = 4l;

        
        //dizemos como o method "findById", da class mockada deve se comportar
        Mockito.when(this.pr.findById(idProcurado)).thenReturn(pOptional); //Quando o method "findById()" for executado, ele deve retornar o aquele "narutinho".
        
        //act (testamos o methods da service)
        Person methodResult = this.ps.getPersonById(idProcurado);


        //assert
        Assertions.assertThat(methodResult).isEqualTo(p1); //afirmamos que o method vai retornar a mesma pessoa informada

    }


    @Test
    public void itShouldThrowsAnExceptionWhenThePersonItDoesentExists(){
        //arrange
        Long idProcurado = 5l;
        
        //informamos como o method da classe mockada vai se comportar
        Mockito.when(this.pr.findById(idProcurado)).thenReturn(Optional.empty()); //simulamos que o method vai retornar um Optional sem "Person"

        // act + assert
        Assertions.assertThatThrownBy(() -> this.ps.getPersonById(idProcurado)) //afirmamos que esse method "getPersonById", que estamos testando, vai retornar uma exception
            .isExactlyInstanceOf(RuntimeException.class) //afirmamos que esse method vai retornar a exception "tal"
            .hasMessageContaining("Person not found"); //afirmamos que essa eh a mensagem dessa exception
    }


    // ============= findByEmail =============
    @Test
    public void itShouldReturnAPersonByEmail(){
        //arrange
        Person expectedResult = new Person("sonic", "sonic@gmail.com");
        Optional<Person> pOptional = Optional.of(expectedResult);
        String emailProcurado = expectedResult.getEmail();

        //o method que vamos testar possui "methods mockados". Logo, precisamos dizer o que esses methods fazem.
        Mockito.when(this.pr.findByEmail(emailProcurado)).thenReturn(pOptional);

        //act
        Person methodResult = this.ps.getPersonByEmail(emailProcurado);

        //assert
        Assertions.assertThat(methodResult).isEqualTo(expectedResult);

    }

    @Test
    public void itShouldThrowAnExceptionIfThereIsNoPersonWithThisEmail(){
        //arrange
        String emailProcurado = "vegeta@gmail.com";

        //o method que vamos testar possui "methods mockados". Ou seja, precisamos informar o comportamento desses methods
        Mockito.when(this.pr.findByEmail(emailProcurado)).thenReturn(Optional.empty()); //esse method mockado vai receber um "email invalido" e retornar um Optional vazio 


        //act + assert
        Assertions.assertThatThrownBy(() -> this.ps.getPersonByEmail(emailProcurado))
            .isExactlyInstanceOf(RuntimeException.class) //afirmamos que esse method vai retornar um erro do tipo "RuntimeException"
            .hasMessageContaining("Person not found"); //afirmamos que essa exception tera exatamente essa mensagem
    }



    // ================================= CREATE =================================
    @Test
    public void itShouldCreateAPersonSuccessfully(){
        //arrange
        PersonCreateDTO pDto = new PersonCreateDTO();
        pDto.setName("sonic");
        pDto.setEmail("sonic@gmail.com");

        Person expectedResult = new Person();
        expectedResult.setId(1l);
        expectedResult.setName(pDto.getName());
        expectedResult.setEmail(pDto.getEmail());

        //definindo o comportamente dos methods "mockados".
        Mockito.when(this.pr.save(Mockito.any())).thenReturn(expectedResult); //no save() informamos qualquer pessoa, e queremos que retorne a pessoa com os os attributes setadinhos igual as da DTO

        //act (executamos o method)
        Person methodResult = this.ps.createPerson(pDto);
       

        //assert
        Assertions.assertThat(methodResult).isNotNull(); //afirmamos que esse method vai retornar uma "pessoa"
        Assertions.assertThat(methodResult).isEqualTo(expectedResult); //afirmamos que esse method vai retornar a pessoa "tal"
        Assertions.assertThat(methodResult.getName()).isEqualTo(pDto.getName()); //afirmamos que esse method vai retornar uma pessoa com o mesmo "name" da informada no parametro desse method
        Assertions.assertThat(methodResult.getEmail()).isEqualTo(pDto.getEmail()); //afirmamos que esse method vai retornar uma pessoa com o mesmo "email" da informada no parametro desse method

        //só toma cuidado com o equals().... Voce teria que sobreescrever o equals() and HashCode()... Chato...
    }



    @Test
    public void itShouldThrowsAnExceptionWhenTheNameIsEmpty(){
        
        //arrange
        PersonCreateDTO newPerson = new PersonCreateDTO();
        newPerson.setEmail("sonic@gmail.com");
        //nao vamos informar o "name" dessa pessoa.

        
        
        //act + assert
        Assertions.assertThatThrownBy(() -> this.ps.createPerson(newPerson)) //afirmamos que esse method vai lancar uma exception
            .isExactlyInstanceOf(NameCannotBeNullException.class) //afirmamos que a exception que será lancada é do tipo "NameCannotBeNullException"
            .hasMessageContaining("Name nao pode estar em branco"); //afirmamos qual será a mensagem da exception
        
    }



    // ================================= UPDATE =================================
    @Test
    public void itShouldUpdateAPersonSuccessfully(){
        //arrange
        Long personId = 44l;
        PersonCreateDTO dadosNovos = new PersonCreateDTO("sonic", "sonic@gmail.com");

        //dados antigos
        Person pessoComDadosAntigos = new Person();
        pessoComDadosAntigos.setId(44l);
        pessoComDadosAntigos.setName("naruto");
        pessoComDadosAntigos.setEmail("narutobotafe@gmail.com");

        //dados atualizados
        Person expectedResult = new Person();
        expectedResult.setId(pessoComDadosAntigos.getId());
        expectedResult.setName(dadosNovos.getName());
        expectedResult.setEmail(dadosNovos.getEmail());

        
        //comportamento do methods "mockados"
        Mockito.when(this.pr.findById(personId)).thenReturn(Optional.of(pessoComDadosAntigos));//o que nós esperamos desse methods mockado é que ele receba um "#ID" e retorna uma "pessoa"
        Mockito.when(this.pr.save(Mockito.any())).thenReturn(expectedResult); //nos definimos que esse method "save()" vai receber qualquer objeto e vai retornar uma "pessoa" com os dados atualizado

        //act
        Person methodResult = this.ps.updatePerson(personId, dadosNovos);

        //assert
        Assertions.assertThat(methodResult).isNotNull(); //afirmamos que esse method vai retornar uma "pessoa" nao null.
        Assertions.assertThat(methodResult.getId()).isEqualTo(personId); //afirmamos que esse method vai retornar uma pessoa com o mesmo "id" do informado para editar
        Assertions.assertThat(methodResult.getName()).isEqualTo(expectedResult.getName()); //afirmamos que esse method vai retornar uma pessoa com o mesmo "name" do informado no body
        Assertions.assertThat(methodResult.getEmail()).isEqualTo(expectedResult.getEmail()); //afirmamos que esse method vai retornar uma pessoa com o mesmo "email" do informado no body

        //só toma cuidado com o equals().... Voce teria que sobreescrever o equals() and HashCode()... Chato...
    }



    @Test
    public void itShouldThrowAnExceptionIfTheIdDoesntExists(){
        //arrange
        Long personId = 50l;

        //setamos o comportamento dos methods "mockados"
        Mockito.when(this.pr.findById(personId)).thenReturn(Optional.empty()); //simulamos que esse method nao encontrou uma "person" com o id informado
        
        //act + assert
        Assertions.assertThatThrownBy(() -> this.ps.deletePerson(personId)) //afirmamos que esse method vai lancar uma exception
            .isExactlyInstanceOf(RuntimeException.class) //afirmamos qual vai ser o tipo dessa exception
            .hasMessageContaining("Nao eh possivel deletar, pois nao existe uma pessoa com esse #id"); //afirmamos qual a mensagem que essa exception possui
    }



    //// ================================= DELETE =================================
    @Test
    public void itShouldDeleteAPersonByIdSuccessfully(){
        //arrange
        Long personId = 33l;
        Person pessoaQueSeraDeletada = new Person();
        String expectedResult = "Deletado com sucesso!";

        
        //setando o comportamento dos methods "mockados"
        Mockito.when(this.pr.findById(personId)).thenReturn(Optional.of(pessoaQueSeraDeletada));
        //this.pr.deleteById() --> Nao precisamos "mockar", pois ele é um method void

        
        //act
        String methodResult = this.ps.deletePerson(personId);


        //assert
        Assertions.assertThat(methodResult).isNotBlank(); //afirmamos que sera retornado algo
        Assertions.assertThat(methodResult).isNotNull(); //afirmamos que sera retornado algo
        Assertions.assertThat(methodResult).isEqualTo(expectedResult); //afirmamos que esse method vai retornar a mensagem que estamos esperando.
    }


    @Test
    public void itShouldThrowAnExceptionBecauseThereIsNoPersonWithThisId(){
        //arrange
        Long personId = 12l;


        //setando o comportamento dos methods "mockados"
        Mockito.when(this.pr.findById(personId)).thenReturn(Optional.empty()); //simulamos o comportamento desse method. Nesse caso, estamos simulando que nao foi encontrado nenhuma "person" com o id informado

        //act + assert
        Assertions.assertThatThrownBy(() -> this.ps.deletePerson(personId)) //afirmamos que esse method vai gerar uma exception
            .isExactlyInstanceOf(RuntimeException.class) //afirmamos o tipo da exception
            .hasMessage("Nao eh possivel deletar, pois nao existe uma pessoa com esse #id"); //afirmamos a mensagem da exception

    }
}
