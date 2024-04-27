package org.example.validation

class NumberValidator:ValidationInterface {
    override fun validate(inputArgument: List<String>, count: Boolean): Boolean {
        try{
            if(count){
                inputArgument[0].toInt()
                return true
            }
            inputArgument[0].toInt()
            inputArgument[1].toInt()
            return true
        }catch (e:NumberFormatException){
            return false
        }
    }
}