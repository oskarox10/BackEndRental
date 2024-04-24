package com.example.demo.Validator;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

public class ManufacturingYearRangeValidator implements ConstraintValidator<ManufacturingYearRange,Short>{

    @Override
    public boolean isValid(Short value, ConstraintValidatorContext constraintValidatorContext) {
        return value >= 1900;
    }

}
