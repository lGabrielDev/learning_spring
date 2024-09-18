package br.com.empresaTal.spring_praticando.student.validations.nameValidations;

import br.com.empresaTal.spring_praticando.student.exception.AttributeIsNullException;
import br.com.empresaTal.spring_praticando.student.exception.NameLengthIsToSmall;

public abstract class NameValidations{

    public static boolean nameAllValidationsAreCorrect(String name) {
        return nameIsNotNull(name) && nameLengthIsCorrect(name);
    }

    public static boolean nameIsNotNull(String name) {
        if(name == null || name.isBlank()){
            throw new AttributeIsNullException("'name' cannot be null");
        }
        return true;
    }


    public static boolean nameLengthIsCorrect(String name) {
        if(name.length() < 5){
            throw new NameLengthIsToSmall("name is too small. Please, type more than 4 characters");
        }
        return true;
    } 
}
