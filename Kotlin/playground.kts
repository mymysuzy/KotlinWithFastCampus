val SAY_YES: String = "좋아"
var sayYes: String = "좋아"

println(sayYes)
println(SAY_YES)

println("////////////")

/*
Null
    -> 상태를 모르거나 존재하지 않음.
    -> 값을 나타내기도 하고 상태를 나타내기도 함.
    -> 연산을 진행하기 전엔 null인지 항상 확인하기.
    -> null으로 사칙연산 할 수 없지만 비교연산은 가능하다.
*/

val NUM1: Int? = null

var number1: Int = 2 + 5
var number2: Int = 3

var number3: Int = number1 + number2
println(number3)

println("////////////")

var number4: Int? = 2 + 5
var number5: Int? = 3

var number6: Int = number4!! + number5!!

println(number6)

println("////////////")

if (null == 3) println("null is 3")
else println("null is not 3")

if (null == null) println("null is null")
else println("null is not null")

println("////////////")

var number7: Int = 1
var number8: Int = 2
val result: Boolean = number7 > number8

println(result)

println("////////////")

fun basicFun(num1: Int, num2: Int): Int {
    val result: Int = num1 + num2

    return result
}

println(basicFun(1, 2))

println("////////////")

//fun defaultNumFun(num1: Int = 1, num2: Int): Int {
//    val result: Int = num1 + num2
//
//    return result
//}
//
//println(defaultNumFun(2))

println("////////////")

fun noReturnValueFun(num1: Int, num2: Int): Unit {
    val result: Int = num1 + num2
    println(result)
}

noReturnValueFun(1, 2)

println("////////////")

fun shortFun(num1: Int, num2: Int): Int = num1 + num2

println(shortFun(1, 2))

println("////////////")

fun varargFun(vararg nums: Int): Unit {
    for (num in nums) {
        println(num)
    }
}

varargFun(1, 2, 3, 4)

println("////////////")

/*
when(조건 검사할 값) {
    case1 -> 동작1
    case2 -> 동작2
    case3 -> 동작3
    else -> 동작4
}
 */

var number9: Int = 1
when (number9) {
    1 -> println("숫자 1 입니다")
    2 -> println("숫자 2 입니다")
    3 -> println("숫자 3 입니다")
    else -> println("이게 뭐고")
}

println("////////////")

println("배열")
println("크기를 직접 지정해야 한다.")
println("사실 배열보단 콜렉션을 더 많이 사용한다.")

var array1 = Array(10, { 0 })
var array2 = Array<Int>(10, { 0 })

println(array1[9])
//println(array2[20]) //-> 에러발생

println("////////////")

array1.set(0, 0)
array1.set(1, 1)

println(array1[0])
println(array1.get(0))
println("------------")
println(array1[1])
println(array1.get(1))

println("////////////")

var array3 = Array<Boolean>(1, { true })
println(array3.get(0))

println("------------")

var array4 = Array<String>(1, { "하나" })
println(array4[0])

println("////////////")

val score1: Int = 1
val score2: Int = 2
val score3: Int = 3

var totalScoreArray = arrayOf<Int>(score1, score2, score3)

println(totalScoreArray.get(2))

println("////////////")

println("콜렉션")
println("불변하는 immutable형태를 사용하자.")
println("단, immutable형태는 고정값이기 때문에 set을 지원하지 않는다.")
println("배열과 달리 크기가 고정되어 있지 않다.")

/*
List
    -> val numbers = listOf<Int>(값1, 값2, 값3)

Set
    -> val numbers = setOf<Int>(값1, 값2, 값3)

Map
    -> val numbers = mapOf<Int>(값1, 값2, 값3)
 */

println("////////////")

val listOfNumbers = listOf<Int>(1, 2, 3)
println(listOfNumbers)

println("////////////")

println(listOfNumbers[0])
println(listOfNumbers.get(0))
println(listOfNumbers.indexOf(1)) // 숫자 1이 담겨있는 인덱스를 알려주는 메서드
println(listOfNumbers.indexOf(0)) // 숫자 0이 담겨있는 인덱스가 없기 때문에 -1을 반환
println(listOfNumbers.first())
println(listOfNumbers.last())

println("////////////")

val setOfNumbers = setOf<Int>(1, 1, 2, 3)
println(setOfNumbers)

println("////////////")

val mapOfNumbers = mapOf<Int, String>(Pair(1, "하나"), Pair(2, "둘"))
println(mapOfNumbers)

println("////////////")

println("Iterable")

val iteralbleRangeWithDots = 1..10
println(iteralbleRangeWithDots)

val iterableRangeWithUntil = 1 until 11
println(iterableRangeWithUntil)

println("////////////")

println("for문")

for (i in 1..3) {
    println(i)
}

println("////////////")

for (j in 1 until 4) println(j)

println("////////////")

for (k in 1..10 step 2) println(k)

println("////////////")

val varNums = listOf<Int>(1, 2, 3, 4, 5)

for (l in varNums) println(l)

println("////////////")

println("forEach 문")

val varNums2 = listOf<Int>(1, 2, 3)

varNums2.forEach {
    println(it)
}

println("------------")

varNums2.forEach { number ->
    println(number)
}

println("////////////")

/*
while 반복문
    -> 무한반복을 막기 위해 while문의 조건을 만족하지 못하는 조건을 반드시 넣어야 한다.
 */

var i = 0

while (i < 5) {
    println(i)
    println("따라서, i는 5미만")
    if (i > 5)
        println("5미만이 아님")
    i++
}

var j = 0

do {
    j++
    println(j)
    println("따라서 j는 5미만")
} while (j < 5)

println("////////////")

println("break문")
println("가장 가까운 loop 탈출")

for (i in 1..3)
    for (j in 1..3) {
        if (j == 2) break
        else println("" + i + "|" + j)
    }

println("------------")


loop@for (i in 1..3)
    for (j in 1..3) {
        if (j == 2) break@loop
        else println("" + i + "|" + j)
    }

println("////////////")
println("continue문")
println("해당 순서 무시하고 다음 순서를 계속 진행")

for (i in 1..3)
    for (j in 1..3) {
        if (j == 2) continue
        else println("" + i + "|" + j)
    }

println("////////////")
println("return 문")

fun returnFun1(): Unit {
    for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) return
            else println("" + i + "|" + j)
        }
    }
}

returnFun1()
