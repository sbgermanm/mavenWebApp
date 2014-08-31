package com.sebas.jbasample3.maverwebapp.annotation;

import com.sebas.jbasample3.maverwebapp.repository.UsuarioRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sgerman
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public void initialize(UniqueUsername a) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext cvc) {
        if (null == usuarioRepository){
            return true;
        }
        return usuarioRepository.findByName(name) == null;
    }
    
}
