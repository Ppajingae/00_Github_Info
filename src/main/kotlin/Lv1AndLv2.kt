package org.example

import java.io.BufferedReader
import java.io.InputStreamReader

class Lv1AndLv2 {
}


fun main() {
    println("메뉴를 입력해주세요.")
    println("1. 게임 시작")
    println("2. 게임 종료")
    val bf = BufferedReader(InputStreamReader(System.`in`))

    var characterList:MutableList<MutableMap<String, String>> = mutableListOf()
    var temp = bf.readLine().toInt()
    while(temp != 1 || temp != 2) {
        when(temp){
            1 -> {println("게임이 시작 되었습니다"); break}
            2 -> {println("게임이 종료 되었습니다"); break}
            else -> println("올바른 값이 아닙니다")
        }
        temp = bf.readLine().toInt()
    }


    if(temp == 1){
        println("캐릭터를 생성해주세요")
        var yesOrNo:Char = 'Y'
        while(yesOrNo == 'Y' || yesOrNo != 'y'){
            val name = bf.readLine()
            val job = bf.readLine()
            val character:MutableMap<String, String> = mutableMapOf("name" to name, "job" to job)
            characterList.add(character)

            println("캐릭터를 추가 생성 하시겠습니까?? Y / N")
            yesOrNo = bf.readLine()[0]
            while(yesOrNo != 'N' || yesOrNo != 'Y' || yesOrNo != 'n' || yesOrNo != 'y'){
                when(yesOrNo){
                    'Y' -> {
                        println("캐릭터를 생성해주세요");
                        break
                    }
                    'y' ->{
                        println("캐릭터를 생성해주세요");
                        break
                    }
                    'N' -> break
                    'n' -> break
                    else ->{
                        println("값을 다시 입력해주세요")
                        yesOrNo = bf.readLine()[0]
                    }
                }
            }


        }


        characterList.forEach{
            println(it)
        }
    }
}

