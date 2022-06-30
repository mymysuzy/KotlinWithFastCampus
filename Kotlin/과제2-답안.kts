// 1번
// 주어진 문자를 N번 반복해서 출력하는 함수

fun repeatPrint(givenWord: String, repeatTime: Int): Unit{
    for (time in 0 until repeatTime) println(givenWord)
}

repeatPrint("안녕",2)

println("//////////////")

// 2번
// 1부터 주어진 숫자까지의 합을 구하는 함수

fun sumUntil(givenNum: Int): Int {
    var result: Int = 0
    for(num in 1..givenNum) result += num

    return result
}

println(sumUntil(10))

println("//////////////")

// 3번
// 1부터 100까지 중 7의 배수의 합을 구하는 함수

fun sumMultipleOfSeven(){
    var result: Int = 0

    for (num in 1..100){
        if (num%7 == 0)
            result += num
    }

    println(result)
}

sumMultipleOfSeven()

println("//////////////")


// 4번
// 100보다 작은 숫자를 넣으면 1씩 증가시켜주고 100이 되면 종료되는 함수

fun stopWhenHundred(givenNum: Int) {
    var number: Int = givenNum
    while(number < 100) {
        println(number)
        number++
    }
}

stopWhenHundred(90)

println("//////////////")

// 5번
// 시험 성적 리스트 [70 , 71, 72, 77, 78, 79, 80, 82, 90 ,99]와 동일한 크기의 배열을 만들고 합격이면 true 불합격이면 false를 담는 함수
// 정답 예시 : (False, False, ...)

// Array 사용 1
val SCORE_LIST = listOf<Int>(70 , 71, 72, 77, 78, 79, 80, 82, 90 ,99)

fun checkPassOrNot(SCORE_LIST: List<Int>): BooleanArray {
    var resultArray = BooleanArray(SCORE_LIST.size, {false})
    SCORE_LIST.forEachIndexed { index, score ->
        if (score >= 80) resultArray[index] = true
    }
    return resultArray
}

val finalResult = checkPassOrNot(SCORE_LIST)

finalResult.forEach {
    println(it)
}

// Array 사용 2
val SCORE_ARRAY_LIST = arrayOf<Int>(70 , 71, 72, 77, 78, 79, 80, 82, 90 ,99)
fun arrayFun (scoreList: Array<Int>) : BooleanArray {
    var result = booleanArrayOf()
    for (i in scoreList) if (i >= 80) result += true else result += false

    return result
}
println(arrayFun(SCORE_LIST).forEach {
    println(it)
})


// Collections의 List 사용

fun checkScore(SCORE_LIST: List<Int>) : List<Boolean> {
    var result = listOf<Boolean>()

    for (score in SCORE_LIST) {
        if (score < 80) result += false
        else result += true
    }
    return result
}
println(checkScore(SCORE_LIST))

// 6번
//두 개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력하는 함수를 만드시오.
//정답 예시 -> [[1, 5], [2, 4], ...]

fun whenSix():List<List<Int>>{
    var result = mutableListOf<List<Int>>()

    for(i in 1..6)
        for (j in 1..6){
            if (i+j == 6) result.add(listOf<Int>(i, j))
        }
    return result
}
println(whenSix())

println("//////////////")

// 7번
// 배부르기 위해서 남은 밥 먹기 횟수, 현재 밥 먹은 횟수 이렇게 두 개를 받는 함수를 만드시오.
// 함수는 "밥을 먹었다" 한 번 출력할 때 마다 밥을 1회 먹은 것으로 간주하고 배가 부를 때 까지 밥을 먹어야 한다.
// 배가 부를 경우에는 "배가 부르다"를 출력한다.
// 배가 아무리 불러도 최소 한 번은 무조건 먹는다.

fun eatFood(leftCnt: Int, ateCnt: Int){
    var leftCntVar: Int = leftCnt
    var ateCntVar: Int = ateCnt

    do {
        println("밥을 먹었다.")
        leftCntVar--
        ateCntVar++
        if (leftCntVar == 0) println("배가부르다.")
    }while(leftCntVar > 0)
}

eatFood(3, 4)

// 8번
// 병사 그룹 2개와 n번재 값을 넣어주면 각각의 병사 그룹에서 n번째 병사를 제거하고 두 개의 병사 그룹을 합쳐주는 함수를 만드시오.

//fun abc(["A", "B", "C", "D", "E"], ["A", "B", "C"], 2) -> null [["A", "B", "C", "D", "E"], ["A", "B"]]

// 함수 실행이 어려운 조건을 만나면 null을 리턴

//fun abc(["A", "B", "C", "D", "E"], ["A", "B", "C"], 100) -> null

fun deleteSth(firstArmy: List<String>,
              secondArmy: List<String>,
              kill: Int): List<List<String>>? {
    if (firstArmy.size < kill || secondArmy.size < kill) return null

    val firstArmyTmp = mutableListOf<String>()
    val secondArmyTmp = mutableListOf<String>()

    for ((index, army) in firstArmy.withIndex()) {
        if (index != kill) firstArmyTmp.add(army)
    }
    for ((index, army) in secondArmy.withIndex()) {
        if (index != kill) secondArmyTmp.add(army)
    }

    val result = listOf<List<String>> (firstArmyTmp, secondArmyTmp)
    return result

}

println(
    deleteSth(
        firstArmy = listOf<String>("A", "B", "C", "D", "E"),
        secondArmy = listOf<String>("A", "B", "C"),
        kill = 2
    )
)

// 9번

// 단수를 입력받아 해당 단수의 값을 리스트로 출력하는 함수를 만드시오.

// fun abc(3) -> [3, 6, 9, 12, 15, 18, 21, 24, 27]

fun abc(number: Int): List<Int>{
    val nums = mutableListOf<Int>()

    for (i in 1..9)
        nums.add(number*i)

    return nums
}

println(abc(3))

// 10번

// 숫자 리스트 한 개를 넣어주면 짝수와 홀수로 분리된 Map을 만드는 함수를 만드시오
// Map의 키는 짝수의 경우 "짝수" 홀수의 경우 "홀수" 한다.

fun splitNumbers(firstIntList: List<Int>, secondIntList: List<Int>): Map<String, List<Int>> {
    val result = mutableMapOf<String, List<Int>>()
    val totalIntList = mutableListOf<Int>()

    totalIntList.addAll(firstIntList)
    totalIntList.addAll(secondIntList)

    val evenNumber = mutableListOf<Int>()
    val oddNumber = mutableListOf<Int>()

    totalIntList.forEach { number ->
        if (number%2 == 0) evenNumber.add(number)
        else oddNumber.add(number)
    }
    result.put("짝수", evenNumber)
    result.put("홀수", oddNumber)

    return result
}

println(
    splitNumbers(
        listOf<Int>(1, 2, 3, 4, 5),
        listOf<Int>(6, 7, 8, 9, 10)
    )
)

