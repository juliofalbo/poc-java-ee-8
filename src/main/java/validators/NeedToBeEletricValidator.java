package validators;

import annotations.NeedToBeEletric;
import enums.EngineType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NeedToBeEletricValidator implements ConstraintValidator<NeedToBeEletric, EngineType> {

    @Override
    public void initialize(NeedToBeEletric constraintAnnotation) {

    }

    @Override
    public boolean isValid(EngineType engineType,
                           ConstraintValidatorContext constraintValidatorContext) {
        return engineType.equals(EngineType.ELETRIC);
    }
}
