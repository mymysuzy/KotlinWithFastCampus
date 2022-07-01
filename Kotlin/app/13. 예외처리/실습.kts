import java.lang.IllegalArgumentException

val numbers = listOf<Int>(1, 2, 3)

try{
    numbers.get(5)
}catch (exception: ArrayIndexOutOfBoundsException){
    println("ArrayIndexOutOfBoundsException 예외발생")
} catch (exception: IllegalArgumentException){
    println("IllegalArgumentException 예외발생")
}
