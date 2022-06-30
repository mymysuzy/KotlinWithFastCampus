// lateinit

class Book2(){
    lateinit var title : String

    fun nextPage(){
        if(::title.isInitialized){
            println("페이지 넘김")
        }else{
            println("초기화 필요")
        }
    }
}

val book2 = Book2()
book2.nextPage()
book2.title = "해리포터2"
book2.nextPage()

//lazy
// - 호출시점에 by lazy정의에 의해 초기화 수행
// - val에서만 사용 가능

class Book3 {
    val title: String by lazy {
        println("lazy 초기화")
        "책 제목"
    }
}