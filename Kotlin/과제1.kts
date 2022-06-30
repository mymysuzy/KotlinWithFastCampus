// 01.변수 ~ 06.흐름제어 과제

// 1번
// 변수 A와 B를 선언하고 두 변수의 값이 같은 경우에는 true 그렇지 않은 경우에는 false가 되는 변수 C를 선언.
// 단, 변수 A와 B의 자료형은 자유지만 에러가 발생하면 안된다.
val A: Int = 1
val B: Int = 2
val C: Boolean = if (A == B) true else false

println(C)

// 2번
// 정수형 변수 A를 선언하고 변수 B를 선언한다. 이 때 변수 B는 A의 두배가 되어야한다.
val D: Int = A * 2
println(D)

// 3번-1 반환값 String
// 학생의 시험 점수를 넣어주면 학점을 반환하는 함수를 만드시오.
// (90점 이상 A, 80점 이상 B, 70점 이상 C, 그렇지 않으면 F)
fun gradeFun1(score: Int): String {
    if (score >= 90) return "A학점"
    else if (score >= 80) return "B학점"
    else if (score >= 70) return "C학점"
    else return "F학점"
}

val result1: String = gradeFun1(10)
println(result1)
//println(gradeFun1(10))

// 3번-2 반환값 없음
fun gradeFun2(score: Int): Unit {
    if (90 <= score) println("A학점")
    else if (80 <= score && score <= 89) println("B학점")
    else if (70 <= score && score <= 79) println("C학점")
    else println("F학점")
}
gradeFun2(90)

// 3번-3 When사용
fun gradeFunWhen(score: Int): String {
    when (score) {
        in 90..100 -> return "A학점"
        in 80..89 -> return "B학점"
        in 70..79 -> return "C학점"
        else -> return "F학점"
    }
}

println(gradeFunWhen(10))

// 4번-1 변수 선언 후 리턴
// 학생이 시험에서 맞은 문제의 갯수를 적어주면 시험 점수를 반환하는 함수
// 총 20문제고 만점은 100점
fun gradeFun3(score: Int): Int {
    val result = score * 5
    return result
}
println(gradeFun3(20))

// 4번-2 바로 리턴
fun gradeFun4(score: Int): Int {
    return score * 5
}
println(gradeFun4(10))

// 4번-3 최대한 간단한 함수로 표현
fun gradeFun5(score: Int): Int = score * 5
println(gradeFun5(5))

// 5번-1
// nullable정수형 두개를 받는 함수를 만든다.
// 이 함수는 받은 인수의 합을 반환하고 이 때 인수중에 null이 있으면 0으로 취급하여 합을 구한다.
// 파라미터는 val값이다!
fun nullalbeFun(nullableA: Int?, nullableB: Int?): Int {
    val first: Int = if (nullableA == null) 0 else nullableA
    val second: Int = if (nullableB == null) 0 else nullableB

    return first + second
}
println(nullalbeFun(null, 10))

// 5번-2
fun nullalbeFun2(nullableA: Int?, nullableB: Int?): Int {
    var first: Int = 0
    if (nullableA != null) first = nullableA

    var second: Int = 0
    if (nullableB != null) second = nullableB

    return first + second
}
println(nullalbeFun2(null, 20))

