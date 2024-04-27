package validation;

import org.example.validation.ValidationInterface

class Validator {
    fun validation(validator: ValidationInterface, argument: List<String>, count:Boolean):Boolean{
        return validator.validate(argument, count)
    }
}
