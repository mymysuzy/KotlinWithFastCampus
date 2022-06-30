//계산기 1
//    - 사칙연산에 대응하는 4개의 함수 구현
//    - 연산이 한번 이루어 질 때 마다 출력을 해야함
//        (사칙연산에 대응하는 4개의 함수에서 출력하면 됨)
//    - setter를 활용해서 풀자


class Calculater {
    var result: Int = 0
        set(value) {
            field = value
            println("중간 계산값: " + field)
        }

    fun sum(inputNum: Int) {
        result += inputNum
    }

    fun minus(inputNum: Int) {
        result -= inputNum
    }

    fun multiple(inputNum: Int) {
        result *= inputNum
    }

    fun divide(inputNum: Int) {
        result /= inputNum
    }
}

val tmp = Calculater()

tmp.sum(10)
tmp.minus(5)

println(tmp.result)


//계산기 2
//    - 사칙연산을 할 수 있는 1개의 함수 구현
//            ex) calculater.calculate('+', 10)
//            ex) calculater.calculate('-', 20)
//    - 초기값을 할당할 수 있어야 하며 초기값을 할당하지 않은 경우에는 0을 기본값으로 사용함
//    - 불가능한 연산을 요청한 경우 "잘못된 연산입니다"를 출력

class Calculater2(val initVal: Int = 0) {
    var result = initVal

    fun calculate(operater: Char, inputNum: Int) {
        when (operater) {
            '+' -> this.result += inputNum
            '-' -> this.result -= inputNum
            '*' -> this.result *= inputNum
            '/' -> this.result /= inputNum
            else -> println("잘못된 접근입니다.")
        }
    }
}

val tmp2 = Calculater2()

tmp2.calculate('+', 10)

println(tmp2.result)

//계산기 3
//    - 사칙연산을 할 수 있는 1개의 함수 구현
//    -  한번에 여러가지의 연산을 입력받을 수 있어야 한다.
//            ex) 더하기3 더하기5 나누기10 곱하기2
//            ex) calculater.calculate(더하기3, 더하기4, 빼기2, 나누기5)

class Calculater3 {
    var result: Int = 0

    fun calculate(operaters: List<Char>, inputNums: List<Int>) {
        operaters.forEachIndexed { index, operater ->
            this._calculate(operater, inputNums[index])
        }
    }

    fun _calculate(function: Char, inputNum: Int) {
        when (function) {
            '+' -> this.result += inputNum
            '-' -> this.result -= inputNum
            '*' -> this.result *= inputNum
            '/' -> this.result /= inputNum
            else -> println("잘못된 연산입니다.")
        }
    }
}

val calculater3 = Calculater3()

calculater3.calculate(listOf<Char>('+', '-'), listOf<Int>(10, 20))

println(calculater3.result)


















