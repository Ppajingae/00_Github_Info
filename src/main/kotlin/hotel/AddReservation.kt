package org.example.hotel

import java.io.BufferedReader
import java.time.LocalDateTime

class AddReservation {
    private var name: String = ""
    private var roomNumber: Int = 0
    private val dateTime = LocalDateTime.now().toLocalDate().toString().split('-')
    private val dateTimeString = dateTime[0] + dateTime[1] + dateTime[2]
    private var checkIn = 0
    //1번 함수
    fun roomReservation(br: BufferedReader){
        //예약자 성함 입력 후에 변수에 저장
        println("예약자 분의 성항을 알려 주세요")
        name = br.readLine()
        //방 번호 입력
        println("예약할 방 번호를 입력해 주세요")
        //if 벙 번호가 100보다 작고 1000보다 클 경우 예외 발생 후에 처리
        var tempRoomNumber = br.readLine()

        //방 번호 잘못 입력시 예외 처리
        while (!numberValidation(tempRoomNumber)) {
            println("방 번호가 잘못 되었습니다 다시 방 번호를 입력해 주세요")
            println("방 번호는 100 ~ 999 영 이내 입니다")
            tempRoomNumber = br.readLine()
            numberValidation(tempRoomNumber)
        }
        roomNumber = roomNumberCheckValidation(tempRoomNumber.toInt(), br)


        //체크인 날짜를 현재 날짜를 가져 와서 비교 후에 현재 날짜 보다 이르면 예외 처리
        println("체크인 날짜를 입력해주세요 표기 형식 -> 19980603 ")
        var tempCheckIn = br.readLine()
        while (!numberValidation(tempCheckIn)) {
            println("날짜 형식이 잘못 되었습니다")
            println("날짜는 YYYYMMDD 방식 으로 작성 부탁 드립니다")
            tempCheckIn = br.readLine()
            numberValidation(tempCheckIn)
        }

        checkIn = checkInValidation(tempCheckIn.toInt() ,br, dateTimeString.toInt())


        //체크 아웃 날짜는 체크인 날짜와 보다 같거나 이르면 예외 처리
        //룸 마다 비용을 다르게 처리 후에 결제 내역 변수에 처리된 결제 값을 입력 후에 저장
    }





    //5번 함수
    fun insertCoinList(){

    }

    //6번 함수
    fun reservationChangeAndCancel(){

    }

    fun elseError(){

    }
}

fun numberValidation(roomNumber:String): Boolean {
    try {
        roomNumber.toInt()
        return true
    }catch (e: NumberFormatException){
        return false
    }
}

fun roomNumberCheckValidation(roomNumber:Int, br: BufferedReader): Int {
    var newRoomNumber:Int
    while (true) {
        try {
            if (roomNumber in 100..999) return roomNumber

            println("올바르지 않은 방 번호 입니다. 방 번호는 100 ~ 999 영역 이내 입니다")
            println("예약할 방 번호를 입력해 주세요")

            newRoomNumber = br.readLine().toInt()
            if (newRoomNumber in 100..999) return newRoomNumber
        }catch (e: NumberFormatException){
            println("잘못 입력 하셨습니다")
        }
    }
}

fun checkInValidation(checkIn: Int, br: BufferedReader, dateTime:Int):Int {
    var newCheckIn:Int
    if(checkIn < dateTime){
        println("처크인은 지난 날을 선택할 수 없습니다")
        while (true){
            try {
                println("현재 날짜 : $dateTime")
                newCheckIn = br.readLine().toInt()
                return newCheckIn
            }catch (e: NumberFormatException){
                println("잘못 입력 하셨습니다")
                println("날짜는 YYYYMMDD 방식 으로 작성 부탁 드립니다")
            }

        }
    }

    return checkIn
}