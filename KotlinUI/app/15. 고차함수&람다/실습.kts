fun addTwoNumbers(number1: Int, number2: Int): Int {
    return number1 + number2
}

//고차함수
fun addTenNine(function: (Int, Int) -> Int) {
    val result: Int = function(10, 9)
    println("결과는 $result 입니다")
}

addTenNine(::addTwoNumbers)

// 람다
// 풀버전
val addTenNine2: (Int, Int) -> Int = {number1: Int, number2: Int ->
    val result = number1 + number2
    result
}


// 람다
// 풀버전2 - 람다함수 자체로 고차함수기 때문에 별도의 연산자 없이 변수에 담을 수 있다.
val addTenNine3: (Int, Int) -> Int = {number1: Int, number2: Int ->

    number1 + number2
}
addTenNine(addTenNine3) // 람다함수를 인자로 사용하는 경우에는 ::을 사용할 필요 없음.

// 생략버전 1
val addTenNine4: (Int, Int) -> Int = {number1, number2 ->

    number1 + number2
}
addTenNine(addTenNine4)

// 생략버전 2
val addTenNine5 = {number1: Int, number2: Int ->

    number1 + number2
}
addTenNine(addTenNine5)

// 완전 간단한 버전
addTenNine {number1, number2 ->  number1 + number2}

// 파라미터가 없는 람다 함수
val addTenNine6: () -> Int = {
    10 + 9
}

val addTenNine7: (Int) -> Int = {
    10 + 9
}


