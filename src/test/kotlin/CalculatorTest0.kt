import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.example.*

class CalculatorTest0 : BehaviorSpec({


    Given("AddOperation Result OK"){

        val calculator = Calculator()

        When("execute operation"){
            val result = calculator.calculate(
                calculatorInterface = AddOperation(),
                num1 = 10,
                num2 = 15)
            then("The result is success"){
                result shouldBe 24
            }
        }
    }

    Given("SubtractOperation Result OK"){

        val calculator = Calculator()

        When("execute operation"){
            val result = calculator.calculate(
                calculatorInterface = SubstractOperation(),
                num1 = 10,
                num2 = 15)
            then("The result is success"){
                result shouldBe -5
            }
        }
    }

    Given("MultiplyOperation Result OK"){

        val calculator = Calculator()

        When("execute operation"){
            val result = calculator.calculate(
                calculatorInterface = MultiplyOperation(),
                num1 = 10,
                num2 = 15)
            then("The result is success"){
                result shouldBe 150
            }
        }
    }

    Given("DivideOperation Result OK"){

        val calculator = Calculator()

        When("execute operation"){
            val result = calculator.calculate(
                calculatorInterface = DivideOperation(),
                num1 = 10,
                num2 = 5)
            then("The result is success"){
                result shouldBe 2
            }
        }
    }

    Given("DivideOperation Result get Throw Exception"){

        val calculator = Calculator()

        When("execute operation"){
            val exception = shouldThrow<Exception> { calculator.calculate(
                calculatorInterface = DivideOperation(),
                num1 = 10,
                num2 = 0) }

            then("The result is success"){
                exception.message shouldBe "0으로 나눌 수 없습니다"
            }
        }
    }

    Given("RemainOperation Result OK"){

        val calculator = Calculator()

        When("execute operation"){
            val result = calculator.calculate(
                calculatorInterface = RemainOperation(),
                num1 = 10,
                num2 = 5)
            then("The result is success"){
                result shouldBe 0
            }
        }
    }

})
