package com.salcorps.springbootdemo3.validations;

import com.salcorps.springbootdemo3.annotation.FieldsValueMatch;
import com.salcorps.springbootdemo3.annotation.PasswordValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator,String> {

    // The main work of this class to make sure that user makes
    // a strong password based on the custom conditions.
    List<String> weakPasswords;
    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
       weakPasswords = Arrays.asList("12345","password","qwerty");
    }
    @Override
    public boolean isValid(String passwordField, ConstraintValidatorContext constraintValidatorContext) {
        // We are trying to check whether the password enter by the user is a strong password  or not.
        // By just looking whether it matches in the array or not.
        return passwordField != null && (!weakPasswords.contains(passwordField));
    }
}
