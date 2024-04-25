package org.example

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    //몇 번 연산 했는지 체크
    var isFirstCalculationCheck = false
    var tempNum: Int = 0

    firstInputNumberCalculationValidator(bufferedReader, isFirstCalculationCheck)




//    while (true){
//        if(i == 0){
//            tempNum += operatorFunction(true, num1.toInt(), operator, num2.toInt(), tempNum)
//        }else{
//            println("추가적으로 연산할 값을 연산자 숫자 순으로 입력해 주세요")
//            println("ex >> + 5")
//            val nextBr = bufferedReader.readLine().split(" ")
//            val newOperator = nextBr[0]
//            operator = operatorValidator(newOperator, bufferedReader, i)
//            if(operator == '='){
//                println("총 계산 값 $tempNum")
//                break
//            }
//            val newNum = nextBr[1]
//            numberValidator(newNum, "1")
//
//            tempNum = operatorFunction(num1=tempNum, num2=newNum.toInt(), isFirst = false, operator = operator, tempNumMain = tempNum)
//        }
//
//        i++
//    }




}

fun operatorValidator(operator: String, count: Boolean):Boolean {
    if (!count) {
        for (i in operator) {
            return i in arrayOf('+', '-', '*', '/' ,'%')
        }
    }else{
        for(i in operator) {
            return i in arrayOf('+', '-', '*', '/', '%', '=')
        }
    }

    return false
}

fun numberValidator(num1: String, num2:String):Boolean{
    try{
        num1.toInt()
        num2.toInt()
        return true
    }catch (e:NumberFormatException){
        return false
    }
}

fun firstInputNumberCalculationValidator(bufferedReader: BufferedReader, isFirstCalculationCheck: Boolean):List<String> {
    var calculationNumberOperationList = ArrayList<String>()
    var isNumberAndOperator = false
    while (!isNumberAndOperator) {
        val tempBr = bufferedReader.readLine().split(" ")
        var firstNumber:String = tempBr[0]
        var operatorString: String = tempBr[1]
        var secondNumber:String = tempBr[2]

        if (!numberValidator(firstNumber, secondNumber)) {
            println("숫자가 잘못 되었습니다")
            println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
            continue
        }

        if (!operatorValidator(operatorString, isFirstCalculationCheck)) {
            println("연산자가 잘못 되었습니다")
            println("연산자는 +, - , *, /, %, = 입력 가능힙니다")
            println("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5")
            continue
        }
        calculationNumberOperationList.addAll(arrayListOf(firstNumber, operatorString, secondNumber))
        isNumberAndOperator = true
    }

    return calculationNumberOperationList
}