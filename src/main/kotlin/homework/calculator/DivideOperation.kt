package org.example.homework.calculator

class DivideOperation: CalculatorInterface {
    override fun result(num1: Int, num2: Int): Int {
        if(num2 == 0){
            throw ArithmeticException("0으로 나눌 수 없습니다")
        }
        return num1 / num2
    }
}