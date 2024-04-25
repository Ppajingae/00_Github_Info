package org.example

fun main() {
    Market().sell()
}

class ItemListClass(
    val name: String,
    var stock : Int
){
    fun sell(count:Int){
        val leftCountAfterSell = stock - count

        if(leftCountAfterSell < 0){
            throw Exception("stack Count Error")
        }

        stock = leftCountAfterSell
    }
}

class Market{
    private val itemList = listOf(
        ItemListClass("무기", 3),
        ItemListClass("갑옷", 2),
        ItemListClass("음식", 0),
        ItemListClass("약초", 1),
    )

    fun sell() {
        printWelcomeMessage()
        getList()

        val typingUserToItem = readLine()!!.toInt()

        processSelling(typingUserToItem)

    }

    private fun getList(){
        itemList.forEachIndexed{ index, item ->
            println("${index + 1}. ${item.name}")
        }
    }

    private fun printWelcomeMessage(){
        println("상점에 오신 것을 환영합니다.")
        println("구매 하고 싶은 아이템 숫자를 입력 해주세요.")
    }

    private fun processSelling(typingUserToItem: Int){
        try {
            itemList[typingUserToItem - 1].sell(1)
        }catch (e: Exception){
            println("재고가 부족합니다!")
            return
        }

        println("판매 되었습니다!")
    }
}