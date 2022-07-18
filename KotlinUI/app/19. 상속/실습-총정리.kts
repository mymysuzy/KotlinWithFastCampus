open class Warrior(name: String, age: Int){
    var userName: String = name
    var userAge: Int = age

    open fun attack(): Int{
        println("공격!!")
        return 10
    }
}

class DefenceWarrior(name: String, age: Int, height: Int): Warrior(name, age){
    var userHeight: Int = height

    fun defence() {
        println("방어..")
    }
}

val defenceWarrior = DefenceWarrior("박소현", 23, 23434)
println(defenceWarrior.userHeight)
println(defenceWarrior.userAge)
println(defenceWarrior.userName)
defenceWarrior.attack()
defenceWarrior.defence()

class HardAttackWarrior: Warrior{
    var power: Int = 0

    constructor(name: String, age: Int, power: Int ): super(name, age){
        this.power = power
    }

    fun hardAttack(){
        println("강하게 공격")
    }

    override fun attack(): Int {
        val attack: Int = super.attack()
        return attack + 10
    }
}

val hardAttackWarrior = HardAttackWarrior("박", 24, 4555)
hardAttackWarrior.hardAttack()
hardAttackWarrior.attack()
