open class Warrior(hp: Int, var power: Int, var armor: Int){
    var killCount: Int = 0

    var isAlive: Boolean = true
        get() {
            if(field == true) println("Warrior는 아직 살아있다. 체력: ${this.hp}")
            else println("Warrior는 죽었다.")

            return field
        }

    var hp: Int = 100
        set(value) {
            if(value<=0){
                field = 0
                this.isAlive = false
            }else field = value
        }

    init {
        this.hp = hp
    }

    open fun attack(monster: Monster){
        println("Warrior가 공격합니다.")
        if(!monster.defense(this)){
            this.killCount += 1
            println("Monster를 처치함. 킬카운트 : ${this.killCount}")
        }
    }

    fun defense(monster: Monster): Boolean{
        var damage: Int
        if (monster.power >= this.armor) damage = monster.power - this.armor
        else {
            damage = 0
            println("Warrior의 방어력이 강해 아무런 타격을 받지 않았습니다.")
        }

        this.hp -= if(damage > 0) damage else 0

        return this.isAlive
    }

    fun levelUp(): Knight? {
        if(this.killCount >= 3){
            println("Knight으로 레벨업")
            return Knight(this)
        }else{
            println("레벨업 할 수 없음. 현재 킬카운트 : ${this.killCount}")
            return null
        }
    }
}

class Monster(hp: Int, var power: Int, var armor: Int){
    var isAlive: Boolean = true
        get() {
            if(field == true) println("Monster는 아직 살아있다. 체력: ${this.hp}")
            else println("Monster는 죽었다.")

            return field
        }

    var hp: Int = 100
        set(value) {
            if(value <= 0){
                field = 0
                this.isAlive = false
            } else field = value // 이 처리를 안해주니 Monster의 체력이 줄어들지 않았다.
        }

    init {
        this.hp = hp
    }

    fun defense(warrior: Warrior): Boolean{
        val damage: Int
        if (warrior.power >= this.armor) damage = warrior.power - this.armor
        else {
            damage = 0
            println("Monster의 방어력이 강해 아무런 타격을 받지 않았습니다.")
        }
        this.hp -= if(damage > 0) damage else 0

        return this.isAlive
    }

    fun bite(warrior: Warrior){
        println("Monster가 물었습니다.")
        if(!warrior.defense(this)){
            println("Warrior는 죽었습니다.")
        }else{
            println("Warrior는 Monster의 공격으로 부터 살아남았습니다.")
        }
    }


}

class Knight(warrir: Warrior): Warrior(warrir.hp, warrir.power, warrir.armor){

    var evergy: Int = 0

    init {
        this.hp = warrir.hp
        this.power = warrir.power
        this.armor = warrir.armor
    }

    override fun attack(monster: Monster) {
        super.attack(monster)
        this.evergy += 1
    }

    fun hardAttack(monster: Monster){
        if (this.evergy >= 3 && monster.isAlive){
            monster.hp -= this.power + 30
            this.evergy -= 3
        }else println("에너지 부족. 현재 에너지 : ${this.evergy}")
    }
}

val warrior = Warrior(100, 10, 10)

while(warrior.killCount <= 3){
    val monster = Monster(20, 20, 5)
    while (monster.  isAlive ){
        warrior.attack(monster)
        monster.bite(warrior)
    }
}

val knight: Knight = warrior.levelUp()!!