//배열 선언 방법
var array1 = arrayOf(true, false, "안녕", 10)

for(i in array1) println(i)

println("////////////")

var array2 = arrayOf<Int>(1, 2, 3)

for(i in array2) println(i)

println("////////////")

var array3 = intArrayOf(1, 2, 3)

for(i in array3) println(i)

println("////////////")

var array4 = Array(10, {0})

for(i in array4) println(i)

println("////////////")

var array5 = Array<Int>(10, {1})

for(i in array5) println(i)

println("////////////")


// 배열의 인자로 변수를 넣는 방법
val score1: Int = 100
val score2: Int = 200
val score3: Int = 300

var scoreArray = arrayOf<Int>(score1, score2, score3)
println(scoreArray.get(0))