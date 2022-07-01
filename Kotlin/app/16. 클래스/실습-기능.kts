class Player(uniform: String, ball: String) {
    val uniform: String
    val ball: String

    init {
        this.uniform = uniform
        this.ball = ball
    }

    fun kick() {
        println("공 참")
    }
}

val player = Player("빨간색", "축구공")

println(player.uniform)
player.kick()

///////////////////////////////////////////////////////
class Player2(uniform: String, ball: String) {
    val uniform: String = uniform
    val ball: String = ball


    fun kick() {
        println("공 참")
    }
}

val player2 = Player2("빨간색", "축구공")

println(player2.uniform)
player2.kick()