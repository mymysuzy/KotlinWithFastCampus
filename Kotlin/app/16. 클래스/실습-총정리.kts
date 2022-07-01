class User1(name: String, age: Int){
    val userName: String = name
    val userAge: Int = age
}
val user1 = User1("박소현", 234)
println(user1.userName)

////////////////////////////////////////////////////////////////////////////

class User2(name: String, age: Int){
    val userName: String = name
    val userAge: Int = age

    var userGender: String = "" // String 초기화 따옴표로만 가능

    constructor(name: String, age: Int, gender: String ):this(name, age){
        this.userGender = gender
    }
}

val user2 = User2("박", 234,"여자")
println(user2.userGender)

////////////////////////////////////////////////////////////////////////////

class Book(){
    var title: String = "모름" // setter에서 다시 값 배정할테니 var이어야 한다.

        get() {
            return field
        }
        set(value) {
            field = value
        }

}

val book = Book()
book.title = "해리포터"
book.title

////////////////////////////////////////////////////////////////////////////

class Book2(){
    lateinit var title: String

    fun nextPage(){
        if(::title.isInitialized){
            println("페이지 넘김")
        }else{
            println("초기화 필요")
        }
    }
}

val book2 = Book2()
book2.nextPage()
book2.title = "로스앤젤레스"
book2.nextPage()