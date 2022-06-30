
// 부모클래스
open class Warrior(var name: String, var age: Int) {
    fun attack(){
        println("공격")
    }
}

// 자식클래스 1 -> 주생성자가 부모클래스를 만들어 주는 경우
class DefenceWarrior(name: String, age: Int, height: Int): Warrior(name, age){

    fun defence() {
        println("방어")
    }
}

val defenceWarrior = DefenceWarrior("박소현", 20, 5)
defenceWarrior.defence()
defenceWarrior.attack()

println("//////////////")

// 자식클래스 2 -> 주생성자가 없는 경우
class HardAttackWarrior: Warrior{
    var power: Int = 0
    constructor(name: String, age: Int, power: Int): super(name, age){
        this.power = power
    }
    fun hardAttack(){
        println("강하게 공격")
    }
}

val hardAttackWarrior = HardAttackWarrior("박소현", 20, 50)
hardAttackWarrior.hardAttack()
hardAttackWarrior.attack()