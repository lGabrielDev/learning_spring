package br.com.empresaTal.spring_praticando.student.validations.emailValidations;


import br.com.empresaTal.spring_praticando.student.StudentRepository;
import br.com.empresaTal.spring_praticando.student.exception.EmailAlreadyExistsException;

public abstract class EmailValidations {
    

    public static boolean emailIsUnique(String email, StudentRepository sr){
        sr.findByEmail(email).ifPresent((student) -> {
            throw new EmailAlreadyExistsException("Email already exists!");
        });
        
        return true;
    };
}
