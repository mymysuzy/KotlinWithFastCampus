//if
val number1: Int = 10

if (number1 == 10) {
    println("number1은 10이다.")
} else if (number1 == 20) {
    println("number1은 20이다.")
} else {
    println("number1은 10도 20도 아니다")
}

// 조건이 아주 간단한 경우1
if (number1 == 10) println("number1은 10이다.")
else if (number1 == 20) println("number1은 20이다.")
else println("number1은 10도 20도 아니다")

// 조건이 아주 간단한 경우2
val number2: Int = 10 + 20
val number3: Int = if (number2 > 30) 40 else 50
println(number3)


//when
val number4: Int = 5
when (number4) {
    5 -> {
        println("5 입니다")
    }
    6 -> {
        println("6 입니다")
    }
    else -> {
        println("모르겠습니다")
    }
}

// 간단히 만들면 아래와 같다.
when (number4) {
    5 -> println("5 입니다")
    6 -> println("6 입니다")
    else -> println("모르겠습니다")
}

// 에러
//when (number4) {
//    5 -> println("5 입니다")
//    6 -> println("6 입니다")
//    "나는 글자" -> println("글자 입니다.")
//    is Boolean -> println("boolean")
//    in 1..10 -> println("숫자는 1과 10 사이에 들어있습니다.")
//    else ->
//        println("모르겠습니다")
//}
