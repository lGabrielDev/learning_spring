package br.com.empresaTal.spring_praticando.student.validations.nameValidations;

public interface NameValidationsInterface {
    
    //methods de validacao
    public boolean nameAllValidationsAreCorrect(String name);
    public boolean nameLengthIsCorrect(String name);
    public boolean nameIsNotNull(String name);

}
