package br.com.lGabrielDev.tests_bolados.models.calculadora;

import br.com.lGabrielDev.tests_bolados.exceptions.DivisionByZeroException;

public class CalculadoraBolada {
    
    //methods para serem testados
    public Double dividirNumeros(Double n1, Double n2) throws DivisionByZeroException{
        if(n2 <= 0){
            throw new DivisionByZeroException("Não é possível dividir por 0");
        }
        return n1/n2;
    }
}
