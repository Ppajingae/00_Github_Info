package org.example

class Algorithm {
}

fun main() {
    println(solution(123456))
}


fun solution(n: Long): Long {
    var answer: String = n.toString()
    var stringLength = answer.length
    var nArray = CharArray(stringLength)
    for (i in 0 until stringLength){
        nArray[i] = answer[i]
    }

    return nArray.sortedDescending().joinToString("").toLong()
}
