package org.example

import org.example.validation.NumberValidator
import org.example.validation.OperatorValidator
import validation.Validator
import java.io.BufferedReader
import java.io.InputStreamReader


fun inputNumberOperatorValidator(bufferedReader: BufferedReader, isFirstCalculationCheck: Boolean):List<String> {
    val calculationNumberOperationList = ArrayList<String>()
    var isNumberAndOperator = false

    var firstNumber:String
    var operatorString: String
    var secondNumber:String

    val validator = Validator()

    while (!isNumberAndOperator) {
        try {
            if(!isFirstCalculationCheck){
                val tempArray = bufferedReader.readLine().split(" ")
                firstNumber = tempArray[0]
                operatorString = tempArray[1]
                secondNumber = tempArray[2]
            }else{
                val tempArray = bufferedReader.readLine().split(" ")
                operatorString  = tempArray[0]
                if (operatorString == "="){
                    firstNumber = "0"
                }else{
                    firstNumber = tempArray[1]
                }
                secondNumber = "0"
            }

            if (!validator.validation(NumberValidator(), arrayListOf(firstNumber, secondNumber), isFirstCalculationCheck)) {
                println("숫자가 잘못 되었습니다")
                println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
                continue
            }

            if (!validator.validation(OperatorValidator(), arrayListOf(operatorString), isFirstCalculationCheck)) {
                println("연산자가 잘못 되었습니다")
                println("연산자는 +, - , *, /, %, = 입력 가능힙니다")
                println("추가 연산자와 값을 띄워쓰기 단위로 입력해주세요 ex > + 5")
                continue
            }
            calculationNumberOperationList.addAll(arrayListOf(firstNumber, operatorString, secondNumber))
            isNumberAndOperator = true
        }catch (e:IndexOutOfBoundsException){
            println(e)
            println("추가 연산자와 값을 띄워쓰기 단위로 입력해주세요 ex > + 5")
        }


    }

    return calculationNumberOperationList
}


fun input(information:String):BufferedReader {
    println(information)
    return BufferedReader(InputStreamReader(System.`in`))
}

fun calculationFunction(isFirst: Boolean, num1:Int, operator:String, num2:Int, tempNumber:Int):Int {
    var calculator = Calculator()
    var tempNum = tempNumber
    if(!isFirst){
       operatorIdentify(operator).let{
            tempNum += calculator.calculate( it , num1 , num2)
            println(tempNum)
        }

        return tempNum
    }else {
        operatorIdentify(operator).let {
            tempNum = calculator.calculate( it , num1 , num2)
            println(tempNum)
        }
        return tempNum
    }

}


fun operatorIdentify(operator: String):CalculatorInterface{
        return when (operator) {
            "+" -> AddOperation()

            "-" -> SubstractOperation()

            "*" -> MultiplyOperation()

            "/" -> DivideOperation()

            "%" -> RemainOperation()

            else -> throw RuntimeException("잘못된 값이 들어 왔습니다")
        }


}