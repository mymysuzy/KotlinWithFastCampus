// 오버로딩 -> 사용빈도 낮음

class Sum {
    fun sum(): Int {
        return 10
    }

    fun sum(number1: Int): Int{
        return number1 + 10
    }
    fun sum(number1: Int, number2: Int): Int {
        return number1 + number2 + 10
    }
}

val sum = Sum()
println(sum.sum())
println(sum.sum(10))

// 오버라이딩
open class Warrior(var name: String, var age: Int) {
    open fun attack(){ // 오버라이드 해주기 위해 open시키자
        println("공격")
    }
    open fun getDefencePower() : Int {
        return 10
    }
}

// 자식클래스 1 -> 주생성자가 부모클래스를 만들어 주는 경우
class DefenceWarrior(name: String, age: Int, height: Int): Warrior(name, age){

    fun defence() {
        println("방어")
    }

    override fun attack() {
        super.attack()
    }

    override fun getDefencePower(): Int {
//        return super.getDefencePower()
        val defenceWarrior: Int = super.getDefencePower()
        return defenceWarrior + 5
    }
}

val defenceWarrior = DefenceWarrior("박소현", 39, 12)
defenceWarrior.attack()
