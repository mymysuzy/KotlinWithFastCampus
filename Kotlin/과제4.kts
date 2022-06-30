//1. Warrior, Knight, Monster는 체력, 공격력, 방어력, 생존여부에 대한 정보가 필요
//2. Warrior는 Monster를 특정 마리수 이상 처치하면 Knight로 레벨업이 가능하다.
//3. Knight는 hardAttack기능이 있고 이 기능을 사용하려면 energy 3이 필요하다.
//4. Warrior가 레벨업을 하는 반복문이 존재해야 한다.
//
//<프로그램 동작 예시>
//
//        Monster 생성
//        Monster가 아직 살아 있습니다. 체력: 50
//Warrior가 공격합니다.
//Monster가 아직 살아 있습니다. 체력: 41
//Monster가 공격합니다.
//Warrior는 죽었습니다.

open class Warrior(hp: Int, var power: Int, var armor: Int) { //hp의 setter를 설정해주기 위해 var를 삭제

    var killCount: Int = 0
    var isAlive: Boolean = true
        get() {
            if (field == true) println("Warrior는 아직 살아있다. 체력: ${this.hp}")
            else println("Warrior는 죽었습니다.")
            return field
        }

    var hp: Int = 100
        set(value) {
            if (value <= 0) {
                field = 0
                this.isAlive = false
            } else field = value
        }

    init {
        this.hp = hp
    }

    open fun attack(monster: Monster) {
        println("Warrior가 공격합니다.")
        if (!monster.defense(this)) {
            this.killCount += 1
            println("몬스터 처치함. 킬카운트 : ${this.killCount}")
        }
    }


    fun defense(monster: Monster): Boolean {
        val damage: Int = monster.power - this.armor
        this.hp -= if (damage > 0) damage else 0
        return this.isAlive
    }

    fun levelUp(): Knight? { // 레벨업을 하면 Knight가 되어야 한다.
        if (this.killCount > 5) {
            println("Knight로 레벨업~!!!")
            return Knight(this)
        } else {
            println("레벨업 할 수 없습니다. 부족한 킬 카운트 : ${this.killCount}")
            return null
        }
    }
}

class Knight(warrior: Warrior) : Warrior(warrior.hp, warrior.power, warrior.armor) {
    var energy: Int = 0

    init {
        this.hp = warrior.hp
        this.power = warrior.power + 2
        this.armor = warrior.armor + 1
    }

    override fun attack(monster: Monster) {
        super.attack(monster)
        this.energy += 1
    }

    fun hardAttack(monster: Monster) {
        if (this.energy >= 3 && monster.isAlive) {
            monster.hp -= this.power + 30
            this.energy -= 3
        } else println("에너지가 부족합니다. 현재 에너지 : ${this.energy}")
    }

}

class Monster(hp: Int, var power: Int, var armor: Int) {
    var isAlive: Boolean = true
        get() {
            if (field == true) println("Monster는 아직 살아있다. 체력: ${this.hp}")
            else println("Monster는 죽었습니다.")
            return field
        }

    var hp: Int = 100
        set(value) {
            if (value <= 0) {
                field = 0
                this.isAlive = false
            } else field = value
        }

    init {
        this.hp = hp
    }

    fun bite(warrior: Warrior) {
        println("Monster가 물었습니다.")
        warrior.defense(this)
    }


    fun defense(warrior: Warrior): Boolean {
        val damage: Int = warrior.power - this.armor
        this.hp -= if (damage > 0) damage else 0
        return this.isAlive

    }
}

val warrior = Warrior(100, 10, 10)
while (warrior.killCount < 10) {
    val monster = Monster(15, 1, 1)
    while (monster.isAlive) {
        warrior.attack(monster)
        monster.bite(warrior)
    }
}
val knight: Knight = warrior.levelUp()!!


