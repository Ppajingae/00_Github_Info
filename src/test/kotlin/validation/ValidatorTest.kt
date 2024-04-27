package validation

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.validation.NumberValidator

class ValidatorTest : BehaviorSpec({

    Given("first calculation Number Validator success") {
        val validator = NumberValidator()
        When("String conversion Integer execute is success") {
            val result = validator.validate(arrayListOf("1", "2"),false)
            then("result is true") {
                result shouldBe true
            }
        }
    }

    Given("first calculation Number Validator fail") {
        val validator = NumberValidator()
        When("String conversion Integer execute is fail") {
            val result = validator.validate(arrayListOf("1", "a"),false)
            then("result is true") {
                result shouldBe false
            }
        }
    }

    Given("next calculation Number Validator success") {
        val validator = NumberValidator()
        When("String conversion Integer execute is success") {
            val result = validator.validate(arrayListOf("1", "2"),true)
            then("result is true") {
                result shouldBe true
            }
        }
    }

    Given("next calculation Number Validator fail") {
        val validator = NumberValidator()
        When("String conversion Integer execute is fail") {
            val result = validator.validate(arrayListOf("a", "a"),true)
            then("result is true") {
                result shouldBe false
            }
        }
    }

})
