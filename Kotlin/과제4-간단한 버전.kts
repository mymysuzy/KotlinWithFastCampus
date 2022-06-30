class Warrior(var hp: Int, var power: Int, var armor: Int) {
    var killCount: Int = 0

    fun attack(monster: Monster) {
        if (killCount == 0) {
            if (monster.defense(this) <= 0) {
                println("Warrior가 Monster를 죽였습니다.")
                killCount += 1
            } else {
                println("Warrior가 Monster를 공격했습니다.")
                println("Monster는 아직 살아있습니다. Monster의 현재 체력: ${monster.hp}")
            }
        } else {
            println("Warrior가 이미 Monster를 죽였습니다.")
        }
    }

    fun defense(monster: Monster): Int {
        val damage: Int = monster.power - this.armor
        this.hp -= if (damage > 0) damage else 0

        return this.hp
    }
}

class Monster(var hp: Int, var power: Int, var armor: Int) {
    var killCount: Int = 0
    var isAlive: Boolean = true

    fun bite(warrior: Warrior) {
        if (killCount == 0) {
            if (warrior.defense(this) <= 0) {
                println("Monster가 Warrior를 죽였습니다.")
                killCount += 1
            } else {
                println("Monster가 Warrior를 공격했습니다.")
                println("Warrior는 아직 살아있습니다. Warrior의 현재 체력: ${warrior.hp}")
            }
        } else {
            println("Monster가 이미 Warrior를 죽였습니다.")
        }
    }

    fun defense(warrior: Warrior): Int {
        val damage: Int = warrior.power - this.armor
        this.hp -= if (damage > 0) damage else 0

        return this.hp
    }
}

var warrior = Warrior(100, 10, 10)
var monster = Monster(20, 20, 5)
