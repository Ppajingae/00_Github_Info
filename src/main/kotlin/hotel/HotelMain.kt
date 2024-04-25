package org.example.hotel

import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalDateTime

fun main(){
    //호텔 예약 할 수 있는 메뉴 표시(6번까지)
    val br = BufferedReader(InputStreamReader(System.`in`))
    println("호텔 예약 프로그램 입니다")
    println("[메뉴]")
    println("1. 방 예약 2. 예약 목록 출력 3. 예약 목록 (정렬) 출력(sort 함수) 4. 종료 5. 금액 입금 출금 내역 목록 출력 6. 예약 변경 / 취소")
    var tempBr = br.readLine()

    when(tempBr){
        "1" -> AddReservation().roomReservation(br)
        "2" -> SelectReservation().reservationList()
        "3" -> SelectReservation().reservationSortList()
        "4" -> systemLogout()
        "5" -> /*insertCoinList()*/ "pass"
        "6" -> "pass"
        else -> elseError()
    }

    //번호 마다 들어 가는 함수로 따로 구현
    //1. 방 목록 2. 예약 목록 출력 3. 예약 목록 (정렬) 출력(sort 함수) 4. 종료 5. 금액 입금 출금 내역 목록 출 6. 예약 변경 / 취소
}

//4번 함수
fun systemLogout(){

}


fun elseError(){

}