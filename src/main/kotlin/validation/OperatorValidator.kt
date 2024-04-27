package org.example.validation

class OperatorValidator:ValidationInterface {
    override fun validate(inputArgument: List<String>, count: Boolean): Boolean {
        if (!count) {
            for (i in inputArgument[0]) {
                return i in arrayOf('+', '-', '*', '/' ,'%')
            }
        }else{
            for(i in inputArgument[0]) {
                return i in arrayOf('+', '-', '*', '/', '%', '=')
            }
        }

        return false
    }
}