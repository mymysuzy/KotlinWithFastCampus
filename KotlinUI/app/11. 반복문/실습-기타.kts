 val numbers = intArrayOf(5, 10, 15)

 for (number in numbers){ // forEach와 동일
     println(number)
 }

 println("///////////////////")

 // 값과 인덱스 모두 필요할 때
 for ((i, v) in numbers.withIndex()){ // forEachIndexed와 동일
     println(""+i+"|"+v)

 }

 println("///////////////////")

 // 인덱스만 필요할 때
 for ( index in numbers.indices) {
     println(index)
 }

 println("///////////////////")
 
//numbers.forEachIndexed { index, i ->
//    // 본문에서 사용될 변수 이름을 기본 제공으로 사용
//}
//
// numbers.forEachIndexed { index, value ->
//     // 본문에서 사용될 변수 이름을 임의로 변경해서 사용
// }