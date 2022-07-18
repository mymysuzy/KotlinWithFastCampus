// List - Immutable
val numbers = listOf<Int>(1, 2, 3)
//numbers[0] = 2 //-> 블가능. error: no set method providing array access. 불변하는 리스트기 때문에 set메서드를 지원하지 않음!
println(numbers)
println("/////////////////")

val NUMS: List<Int> = listOf<Int>(1, 2, 3)

for(i in NUMS) println(i)

println("/////////////////")

println(numbers[0])
println(numbers.get(0))
println(numbers.indexOf(1))
println(numbers.last())
println(numbers.first())
println("/////////////////")

// List - mutable
val numbers2 = mutableListOf<Int>(1, 2, 3)
numbers2[0] = 2
println(numbers2)
println("/////////////////")

numbers2.add(55)
println(numbers2)

numbers2.removeAt(0)
println(numbers2)
println("/////////////////")

// Set - Immutable
val numbers3 = setOf<Int>(1, 1, 2, 3)
println(numbers3)
println("/////////////////")

val NUMS2: Set<Int> = setOf<Int>(1, 2, 3)

for(i in NUMS2) println(i)

println("/////////////////")

// Set - mutable
val numbers4 = mutableSetOf<Int>(1, 1, 2, 3)
println(numbers4)
println("/////////////////")


// Map - Immutable
val numbers5 = mapOf<Int, String>(1 to "하나", 2 to "둘")
println(numbers5)
println("/////////////////")

val numbers6 = mapOf<Int, String>(Pair(1,  "하나"), Pair(2, "둘"))
println(numbers6)
println("/////////////////")

val NUMS3: Map<Int, String> = mapOf<Int, String>(1 to "하나", 2 to "둘")

println(NUMS3)
println("/////////////////")

// Map - mutable
val numbers7 = mutableMapOf<Int, String>(1 to "하나", 2 to "둘")
println(numbers7)
