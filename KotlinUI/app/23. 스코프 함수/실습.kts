class Person(var name: String? = null, var age: Int? = null){}

// apply
// - apply가 끝나야 객체가 만들어 진다
// - 객체를 반환

// - "객체를 초기화할 때 사용하면 좋다"

// - init블럭을 함수 밖으로 빼놓은 상태라 보면 된다
val gildong = Person().apply {
    this.name = "길동"
    age = 20
}


// also
// - Person 클래스를 의미하는게 아니라 Person클래스로 만들어진 객체를 의미
// - 이미 Person("victor")에서 객체가 만들어진 상태이며
//   이미 만들어진 객체가 it이라는 scope로 넘어가는 것임

// - "유효성 검사를 할 때"
// - 수신된 객체의 속성을 변경하지 않고 사용할 때
val gildong2 = Person("victor").also {
//    nameIsGildong(it.name)
}

//run
// - 기본적으로 apply와 동일

// - 스코프의 마지막줄을 리턴하기 때문에 특정 계산 결과가 필요한 경우사용하자
val ageAfter10years = Person("gildong", 10).run{
    age!! + 10
}


val ageAfter10years2 = with(Person("gildong", 10)){
    age!! + 10
}

//println(ageAfter10years)
println(ageAfter10years2)

//let
// - 기본적으로 also와 동일하다
// - 스코프의 마지막 줄을 리턴한다

// - "nullable검사하는 경우"
//   "?.let 이전의 것이 null이 아니라면 let안의 괄호를 실행시키겠다는 의미"
val gildong5 = Person("victor")?.let {
    it.age = 5

}