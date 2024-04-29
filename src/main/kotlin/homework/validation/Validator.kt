package org.example.homework.validation;

import org.example.homework.validation.ValidationInterface

class Validator {
    fun validation(validator: ValidationInterface, argument: List<String>, count:Boolean):Boolean{
        return validator.validate(argument, count)
    }
}
