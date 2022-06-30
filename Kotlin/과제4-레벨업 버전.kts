open class Warrior(var hp: Int, var power: Int, var armor: Int) {
    var killCount: Int = 0
    var isAlive: Boolean = true

    open fun attack(monster: Monster) {

        if (monster.defense(this) <= 0) {
            killCount += 1
            println("Warrior가 Monster를 죽였습니다. 킬 카운트: ${this.killCount}")

        } else {
            println("Warrior가 Monster를 공격했습니다.")
            println("Monster는 아직 살아있습니다. Monster의 현재 체력: ${monster.hp}")
        }

    }

    fun defense(monster: Monster): Int {
        val damage: Int = monster.power - this.armor
        this.hp -= if (damage > 0) damage else 0

        return this.hp
    }

    fun levelUp(): Knight {
        if (this.killCount >= 3)
            println("Knight로 레벨업~~!!")
        return Knight(this)
    }
}

class Monster(var hp: Int, var power: Int, var armor: Int) {
    var isAlive: Boolean = true

    fun bite(warrior: Warrior) {

        if (warrior.defense(this) <= 0) {
            println("Monster가 Warrior를 죽였습니다.")
            warrior.isAlive = false

        } else {
            println("Monster가 Warrior를 공격했습니다.")
            println("Warrior는 아직 살아있습니다. Warrior의 현재 체력: ${warrior.hp}")
        }

    }

    fun defense(warrior: Warrior): Int {
        val damage: Int = warrior.power - this.armor
        this.hp -= if (damage > 0) damage else 0

        return this.hp
    }
}

class Knight(warrior: Warrior) : Warrior(warrior.hp, warrior.power, warrior.armor) {
    init {
        this.hp = warrior.hp + 10
        this.power = warrior.power + 10
        this.armor = warrior.armor + 10
    }

    override fun attack(monster: Monster) {
        super.attack(monster)
    }

    fun hardAttack(monster: Monster) {
        if (monster.isAlive) {
            monster.hp -= this.power + 50
            println("Knight가 hardAttack을 시전하였습니다.")
        }
    }
}

var warrior = Warrior(100, 10, 10)


loop@while (warrior.killCount <= 5) {
    val monster = Monster(20, 20, 5)
    while (monster.isAlive) {
        warrior.attack(monster)
        if (!warrior.isAlive) break@loop
    }
}

val knight: Knight = warrior.levelUp()