package org.example


//추상 클래스 선언
interface Calculator{
    //추상 함수 선언
    fun result(num1:Int, num2:Int):Int

}



//하위 클래스 에서 2개 이상의 추상 클래스 상속을 받을 수 없다
class AddOperation: Calculator{
    //추상 함수 재정의
    override fun result(num1: Int,  num2: Int):Int {
        return num1 + num2
    }

}

class SubstractOperation: Calculator{
    override fun result(num1: Int, num2: Int): Int {
       return num1 - num2
    }

}

class MultiplyOperation: Calculator{
    override fun result(num1: Int, num2: Int): Int {
        return num1 * num2
    }
}

class DivideOperation: Calculator{
    override fun result(num1: Int, num2: Int): Int {
        return num1 / num2
    }
}

class RemainOperation: Calculator{
    override fun result(num1: Int, num2: Int): Int {
       return num1 % num2
    }
}
