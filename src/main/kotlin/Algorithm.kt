package org.example


class Algorithm {
}

fun main() {
    println(solution("qwer"))
    println("-------------------------")

}


fun solution(s: String): String {
    var answer = ""
    //가운데 글자를 가져 오는 방법
    if(s.length % 2 != 0){
        answer = s[s.length / 2].toString()
    }else{
        val int = s.length / 2
        answer = s[int - 1].toString() + s[int].toString()
    }
    //짝수 일 경우 아닐 경우

    return answer
}