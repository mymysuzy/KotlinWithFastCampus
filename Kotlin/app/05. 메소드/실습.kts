// 기본적인 함수 선언법
fun plusNumbers(firstNum: Int, secondNum: Int): Int {
    val result: Int = firstNum + secondNum

    return result
}

// plusNumbers 호출 방법 1
println(plusNumbers(10, 20))

// plusNumbers 호출 방법 2
val result: Int = plusNumbers(10, 20)
println(result)

////////////////////////////////////////////////////////

// 기본값이 있는 함수 선언법
fun plusNumbersWithDefault(firstNum: Int, secondNum: Int = 10): Int {
    return firstNum + secondNum

}

val result2: Int = plusNumbersWithDefault(10)
println(result2)

val result3: Int = plusNumbersWithDefault(10, 20)
println(result3)

////////////////////////////////////////////////////////

// 반환값이 없는 함수 선언법
// 1. Unit 기입 -> 추천
fun plusNumberWithNoReturn(firstNum: Int, secondNum: Int): Unit {
    val result4: Int = firstNum + secondNum
    println(result4)
}

plusNumberWithNoReturn(100, 200)

// 2. Unit 삭제 -> 추천
fun plusNumberWithNoReturn2(firstNum: Int, secondNum: Int) {
    val result4: Int = firstNum + secondNum
    println(result4)
}

plusNumberWithNoReturn(100, 200)

// 3. 반환하는 값이 없는 상태에서 return만 기입 -> 비추천
fun plusNumberWithNoReturn3(firstNum: Int, secondNum: Int) {
    val result4: Int = firstNum + secondNum
    println(result4)
    return
}

plusNumberWithNoReturn(100, 200)

////////////////////////////////////////////////////////

// 함수 선언을 간단하게 하는 방법
fun shortNumbers(firstNum: Int, secondNum: Int) = firstNum + secondNum
val result4: Int = shortNumbers(10, 100)
println(result4)

// 가변인자를 갖는 함수
fun plusMultipleNums(vararg  numbers: Int): Unit { // `반환값이 없고` 오로지 `출력`만 하는 함수이기 때문에  Unit을 적어줘야 한다!!
//    println(numbers) -> 이렇게 numbers를 출력해보려하면 [I@45fdd38d와 같은 값이 나온다.
    for(number in numbers){
        println(number)
    }
}
plusMultipleNums(1, 2, 3, 4, 5)

// 참고!!
// 함수에 return값이 있을 경우 -> 함수 사용 시 반드시 println해줘야 하며,
// 만약 return값이 없는 Unit일 때엔 -> 함수 선언 후 println안해줘도 된다.
//
// 함수 내부에서 부터 println해주고 있기 때문!
// 오히려 println해주게되면 kotlin.unit이 결과값과 함께 반환된다.