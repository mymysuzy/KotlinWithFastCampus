//break

for(i in 1..3){
    for(j in 1..3){
        if(j == 2) break
        else println("j")
    }
}
println("/////////////////")

for(i in 1..3){
    println("i : " + i)
    for(j in 1..3){
        if (j == 2) break
        else println("j : " + j)
    }
}
println("/////////////////")

//continue

for(i in 1..3){
    println("i : " + i)
    for(j in 1..3){
        if (j == 2) continue
        else println("j : " + j)
    }
}
println("/////////////////")

//return
fun returnFun(): Unit {
    for (i in 1..3) {
        println("i : " + i)
        for (j in 1..3) {
            if (j == 2) return
            else println("j : " + j)
        }
    }
}

returnFun()
println("/////////////////")

// label
// (1) break에 라벨
loop@for(i in 1..3){
    println("i : " + i)
    for(j in 1..3){
        if (j == 2) break@loop
        else println("j : " + j)
    }
}
println("/////////////////")

// (2) continue에 라벨
loop@for(i in 1..3){
    println("i : " + i)
    for(j in 1..3){
        if (j == 2) continue@loop
        else println("j : " + j)
    }
}
println("/////////////////")

// (3) forEach에 라벨
// -> forEach에는 break와 continue 사용불가. return만 됨.
// 아래처럼 잘 사용하진X

listOf<Int>(1, 2, 3).forEach loop@{
    if(it == 2) return@loop
    else println(it)
}

