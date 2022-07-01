//getter/setter

class Book() {
    var title: String = "모름"
        get() {
            return field // title이 아닌 field로 불려야함
        }
        set(value) {
//            println(value)
            field = value
        }
}

val book = Book()
println(book.title)

book.title = "제목변경" // "제목변경"이 value임.
println(book.title)