val NUMBER1: Int? = null
//val NUMBER2: Int = null -> 에러발생.

var number1: Int? = 2+5
var number2: Int? = 10
//var number3: Int? = number1 + number2 -> 에러발생. number1과 number2는 null이 될 수도 있다고 설정되어있기 때문.

var number3: Int? = number1!! + number2!! // -> 에러발생X.
// ?를 통해 null혹은 숫자가 될 수 있다고 내가 설정해뒀긴한데, 나 믿고 숫자라고 생각해 라는 의미의 !!를 추가해주었기 때문.

println(number3)
// 다만 주의할 점은, 사실 null일 경우엔 NullPointerException이 발생할 수 있다.

// 결론!!
// 100% 확신하는 경우가 아니면 !!는 사용하지 말자.

// null을 `값`으로서 비교한 작업
if(null == 5){
    println("same")
} else {
    println("not same")
}

// null을 값으로서가 아닌 `상태`로서, 같은 상태인지 비교한 작업
if(null == null){
    println("same")
} else {
    println("not same")
}

// 결론!!
// Null은 `값`을 나타내기도 하지만 `상태`를 나타내기도 한다.