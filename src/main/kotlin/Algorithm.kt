package org.example


class Algorithm {
}

fun main() {

    println(solution(3,1000000000,4))

}


fun solution(price: Int, money: Int, count: Int): Long {
    val result = money.toLong() - 1.rangeTo(count).map{it * price.toLong()}.sum()
    if (result > 0) return 0L else return (result * (-1))
}