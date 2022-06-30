interface Tiger {
    fun bite()
    fun goToBox()
}

class BackDoSanTiger : Tiger {
    override fun bite() {
    }

    override fun goToBox() {
    }
}

val backdosantiger = BackDoSanTiger()
backdosantiger.bite()
backdosantiger.goToBox()

////////////////////////////////////////////////////////

interface Person {
    var dress: String
    fun eat()
    fun sleep(){ // sleep이 이렇게 구현되어 있으면 Person을 인터페이스로 사용하는 클래스에는 구현을 해줘도 되고 안해줘도 된다.
        println("잠을 잔다")
    }
}

class Student : Person {
    override var dress: String
        get() = "교복"
        set(value) {}

    final override fun eat() { // -> override를 막는 키워드 final
        println("밥을 먹는다.")
    }

    fun study(){
         println("공부를 한다")
    }

}

class GoodStudent: Student {

}

class Teacher: Person{
    override var dress: String
        get() = "정장"
        set(value) {}

    override fun eat() {
    }
}

val student : Student = Student()

student.dress
student.eat()
student.sleep()