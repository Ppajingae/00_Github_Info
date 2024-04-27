package org.example


//추상 클래스 선언
interface CalculatorInterface{
    //추상 함수 선언
    fun result(num1:Int, num2:Int):Int

}

class Calculator{
    fun calculate(calculatorInterface: CalculatorInterface, num1:Int, num2:Int) = calculatorInterface.result(num1, num2)
}



//하위 클래스 에서 2개 이상의 추상 클래스 상속을 받을 수 없다
class AddOperation: CalculatorInterface{
    //추상 함수 재정의
    override fun result(num1: Int,  num2: Int):Int {
        return num1 + num2
    }

}

class SubstractOperation: CalculatorInterface{
    override fun result(num1: Int, num2: Int): Int {
       return num1 - num2
    }

}

class MultiplyOperation: CalculatorInterface{
    override fun result(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}

class DivideOperation: CalculatorInterface{
    override fun result(num1: Int, num2: Int): Int {
        if(num2 == 0){
            throw ArithmeticException("0으로 나눌 수 없습니다")
        }
        return num1 / num2
    }
}

class RemainOperation: CalculatorInterface{
    override fun result(num1: Int, num2: Int): Int {
       return num1 % num2
    }
}
