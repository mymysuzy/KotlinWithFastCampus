// Scope

var  number: Int = 1

fun changeNumber() {
    var internalNumber: Int = 44
    number = 20
}

changeNumber()
println(number) // 하위스코프에서 상위 멤버에 접근할 수 있다.
//internalNumber = 66 -> 불가능

class Numbers(var number: Int = 10) {

}

val numbers = Numbers()
println(numbers.number)

numbers.number = 100

println(numbers.number)

//class Numbers2(private var number: Int = 10) {
//
//}
//
//val numbers2 = Numbers2()
//println(numbers2.number)
//
//numbers2.number = 100
//
//println(numbers2.number) 에러남.