class User1 constructor(name: String) {
    val userName: String

    init {
        userName = name

        println("init에 출력가능")
    }
}

val user1 = User1("박소현") // 클래스를 호출 -> 인스턴스화
println(user1.userName)

////////////////////////////////////////

class User2 constructor(name: String) {
    val userName: String = name
}

val user2 = User2("박소현2")
println(user2.userName)

////////////////////////////////////////

class User3(name: String) {
    val userName: String = name
}

val user3 = User3("박소현3")
println(user3.userName)

////////////////////////////////////////

class User4(name: String = "박소현4"){ // 기본값이 있는 주생성자
    val userName = name
}

val user4 = User4()
println(user4.userName)

////////////////////////////////////////
// 생성자에서 받는 속성이 복수개인 경우
// Java 스타일
class User5(name: String, age: Int) {
    val name: String
    val age: Int

    init {
        this.name = name
        this.age = age
    }
}

val user5 = User5("박소현5", 5)
println(user5.age)