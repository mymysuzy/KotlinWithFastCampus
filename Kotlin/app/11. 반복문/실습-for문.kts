//for 반복문

for (value in 1..10) {
    println("반복")
}
println("//////////////////")

for (value in 0..5 step 2) {
    println("반복2")
}
println("//////////////////")

for (value in 5 downTo 0) {
    println("반복3")
}
println("//////////////////")

val numbers = listOf<Int>(0, 1, 2, 3)

for (number in numbers) {
    println(number)
}
println("//////////////////")

for (i in 1..numbers.size) {
    println("반복4")
}
println("//////////////////")

for (i in 0 until numbers.size) {
    println("반복5")
}
println("//////////////////")

for ((index, number) in numbers.withIndex()) {
    println("" + index + "|" + number)
}
println("//////////////////")

//////////////////////////////////////////////////////////
//forEach
numbers.forEach {
    println(it)
}
println("//////////////////")

numbers.forEach { number ->
    println(number)
}
