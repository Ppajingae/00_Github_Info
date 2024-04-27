package org.example


fun main() {

    //몇 번 연산 했는지 체크
    var isFirstCalculationCheck = false
    var tempNumber: Int = 0

    val startCalculator =
        inputNumberOperatorValidator(input("입력하고 싶은 값과 연산자를 띄워쓰기 단위로 입력해주세요 ex > 10 + 5"), isFirstCalculationCheck)

    while (true){
        if(!isFirstCalculationCheck){
            tempNumber += calculationFunction(
                isFirst = isFirstCalculationCheck,
                num1= startCalculator[0].toInt(),
                num2= startCalculator[2].toInt(),
                operator = startCalculator[1],
                tempNumber = tempNumber
            )

            isFirstCalculationCheck = true
        }else{
            val nextCalculation =
                inputNumberOperatorValidator(input("추가 연산자와 값을 띄워쓰기 단위로 입력해주세요 ex > + 5"),isFirstCalculationCheck)

            if (nextCalculation[1] == "="){
                println("총 계산 값 $tempNumber")
                break
            }

            tempNumber = calculationFunction(
                isFirst = isFirstCalculationCheck,
                num1= tempNumber,
                num2= nextCalculation[0].toInt(),
                operator = nextCalculation[1],
                tempNumber = tempNumber
            )


        }
    }

}
