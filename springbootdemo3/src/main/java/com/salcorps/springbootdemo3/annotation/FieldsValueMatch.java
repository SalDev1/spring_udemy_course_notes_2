package com.salcorps.springbootdemo3.annotation;


import com.salcorps.springbootdemo3.validations.FieldsValueMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.thymeleaf.spring6.expression.Fields;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldsValueMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldsValueMatch {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String message() default "Fields values don't match!";

    /*
      The below code make sures that it validates
      the content of two different fields.

      It accepts two field information where we are trying
      to do the validations.
    * */
    String field();  // Field 1
    String fieldMatch(); // Field 2
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        FieldsValueMatch[] value();
    }
}
