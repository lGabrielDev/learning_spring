package br.com.lGabrielDev.tests_bolados.models.calculadora;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.lGabrielDev.tests_bolados.exceptions.DivisionByZeroException;


public class CalculadoraBoladaTest {
    
    //testando se o method ta funcionando bonitinho
    @Test
    public void divinding10By2ItShouldReturn5() throws Exception{ 
        //arrange (organizando)
        Double n1 = 10d;
        Double n2 = 2d;
        Double expectedResult = 5d;
        CalculadoraBolada c1 = new CalculadoraBolada();

        //act (executando o method que sera testado)
        Double methodResult = c1.dividirNumeros(n1, n2);

        //assert (afirmacoes que esperamos receber)
        Assertions.assertThat(methodResult).isEqualTo(expectedResult); // 10 / 2 = 5
    }


    //testando se o method está lancando a exception quando preciso
    @Test
    public void itShouldThrowsAnExceptionWhenDividingBy0() throws DivisionByZeroException{
        //arrange
        Double n1 = 50d;
        Double n2 = 0d;
        CalculadoraBolada c1 = new CalculadoraBolada();
        
        
        //act + assert juntos
        Assertions.assertThatThrownBy(() -> c1.dividirNumeros(n1, n2)) //Esse method "assertThatThrownBy" espera um bloco de codigo que vai lancar um erro. Por isso, usamos lambda.
            .isExactlyInstanceOf(DivisionByZeroException.class) //Afirmamos que o method acima vai lancar uma "DivisionByZeroException"
            .hasMessageContaining("Não é possível dividir por 0"); //Afirmamos que a exception lancada tera exatamente essa mensagem
            
    }
}
