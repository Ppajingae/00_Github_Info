import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.example.Bag
import org.example.Item

class BagTest : BehaviorSpec({

    Given("a valid max weight") {
        val validMaxWeight = 10
        When("execute constructor"){
            val result = Bag(validMaxWeight)
            Then("created max weight should be valid max weight") {
                //생성자를 통해서 집어 넣은 매개 변수와 같은지 확인
                result.maxWeight shouldBe validMaxWeight
            }
        }
    }

    Given("a max weight = 0") {
        val maxWeight = 0
        When("execute constructor"){


            val exception = shouldThrow<Exception> {  Bag(maxWeight) }

            Then("created max weight should be valid max weight") {
                exception.message shouldBe "가방의 최대 무게가 잘못 설정되었습니다."
            }
        }
    }

    Given("a max weight < 0") {
        val maxWeight = -10
        When("execute constructor"){

            val result = Bag(maxWeight)
            val exception = shouldThrow<Exception> {  Bag(maxWeight) }

            Then("created max weight should be valid max weight") {
                exception.message shouldBe "가방에 아이템을 넣을 수 없습니다."
            }
        }
    }

    Given("a max weight < item.weight + currentWeight") {
        val maxWeight = 10
        val item = Item("test", 20)
        When("execute constructor"){
            val exception = shouldThrow<Exception> { Bag(maxWeight).putItem(item) }
            Then("created max weight should be valid max weight") {
                exception.message shouldBe "가방에 아이템을 넣을 수 없습니다."
            }
        }
    }

    Given("a max weight > item.weight + currentWeight") {
        val bag = Bag(100)
        val item = Item("test", 20)
        When("execute constructor"){
            val result = bag.putItem(item)
            Then("created max weight should be valid max weight") {
                bag.itemList.size shouldBe 1

                bag.itemList.first() shouldBe item
            }
        }
    }

})
