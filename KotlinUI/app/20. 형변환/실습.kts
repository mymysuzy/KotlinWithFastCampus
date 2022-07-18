//기본자료형의 타입캐스팅 -> to타입이 오는 함수를 이용해 형변환을 한다
val number: Int = 10
val numberString: String = number.toString()

println(numberString)

val stringToNumber: Int = numberString.toInt()

println(stringToNumber)

/////////////////////////////////////////////

// 상속한 클래스간의 캐스팅

open class Warrior(var name: String, var age: Int) {
    open fun attack(){ // 오버라이드 해주기 위해 open시키자
        println("공격")
    }

}

class DefenceWarrior(name: String, age: Int, height: Int): Warrior(name, age){

    fun defence() {
        println("방어")
    }
}

val warrior: Warrior = DefenceWarrior("박소현", 29, 349) // var는 변경이될 수 있기 때문에 스마트 캐스팅이 안된다.
println(warrior.attack()) // warrior.defence()는 사용 불가능. defence기능을 포기하고 warrior타입이 되었기 때문에.

// is -> 타입 체크. true or false가 리턴된다. 그리고 스마트캐스팅 해줌.
if(warrior is DefenceWarrior){
    // 스마트 캐스팅
    // -> 내가 만든 warrior를 if블럭 안에서는 defenceWarrior로 사용하게 해준다
    warrior.defence()
}

// as -> 지정한 타입으로 캐스팅을 시도하고 불가능한 경우에는 예외발생
val warrior2: DefenceWarrior = warrior as DefenceWarrior
warrior2.defence()