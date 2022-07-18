//?
val number: Int = 10 // non-nullable Int
val number: Int? = null // nullable Int

//!! -> 정말 필요한 경우에만 사용하기
val nullableNumberList: List<Int?> = listOf<Int?>(1, 2, 3, 4, 5)
var result: Int = 0

nullableNumberList.forEach {
    result += it!!
}

// ?.
val text: String? = "txt"
//val text: String? = null
println(text?.length)

// !!.
//println(text!!.length) -> NullPointerException이 발생해야함

// as?
open class Warrior(var name: String, var power: Int, var type: String){
    fun attack(){
    println("공격")}
}

class DefenceWarrior (var name: String, var power: Int){ // 상속안함
    fun defence(){
        println("방어")
    }
}

val defenceWarrior = DefenceWarrior("가", 123)
val warrior = defenceWarrior as? Warrior
//val warrior = defenceWarrior as Warrior -> 에러 발생

//println(warrior)

// ?: 엘비스 연산
val text2 : String? = "123"
val nullText: String? = null

var len1: Int = if(text2 != null) text2.length else 0
var len2: Int = text2?.length ?: 0