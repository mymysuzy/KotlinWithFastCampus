// 부생성자 (Secondary Constructor)


//실행순서
// 부생성자 호출 -> 부생성자 안의 주생성자 호출 -> init 호출 -> 부생성자 실행
class User1(name: String) {
    var age: Int = 0 //init블럭 안에 들어가있지 않기 때문에 여기서 직접 초기화해줘야 한다.
    var name: String

    init { // 초기화블럭은 클래스가 생성될 때 무조건 실행되기 때문에 무조건 초기화된다.
        // 따라서 초기화블럭에 없는 속성은 선언할 때 초기화해줘야한다.
        this.name = name
        //println 동작함
    }

    // 부생성자
    // - 부생성자는 클래스명 우측에 올 수 없다.
    // - 클래스의 본문에 있어야 한다.
    constructor(name: String, age: Int) : this(name) {
        this.age = age
        //println 동작함
    }
}

val user1 = User1("가나다", 20)
println(user1.name)

///////////////////////////////////////////////////////////////////////////

class User4(name: String, age: Int) {
    var userName: String = name
    var userAge: Int = age

    var gender: String = "여자"

    constructor(name: String, age: Int, gender: String) : this(name, age) {
        this.gender = gender
    }
}

val user4 = User4("박소현", 23, "남자")
println(user4.gender)


