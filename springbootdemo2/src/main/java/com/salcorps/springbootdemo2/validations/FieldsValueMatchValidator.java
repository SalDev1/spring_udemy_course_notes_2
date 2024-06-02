package com.salcorps.springbootdemo2.validations;

import com.salcorps.springbootdemo2.annotation.FieldsValueMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch,Object> {
    private String field;
    private String fieldMatch;

    @Override
    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        // Your field is getting validated two times in a row.
//        if(fieldValue != null) {
//            // If the hashed value exists within the password,
//            // return true , as it is encoded with Bcrypt Algorithm.
//            if(fieldValue.toString().startsWith("$2a")) {
//                return true;
//            }
//            else {
//                // If the password is in the normal text form , do this.
//                return fieldValue.equals(fieldMatchValue);
//            }
//        }
//        else {
//            return fieldMatchValue == null;
//        }

        if(fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        }
        else {
            return fieldMatchValue == null;
        }
    }
    // The main job of this class is to check whether
    // two fields have the same data or not.

}
