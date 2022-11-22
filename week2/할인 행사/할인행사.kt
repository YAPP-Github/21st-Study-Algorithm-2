/**
 *  discount의 size -9 번 반복.
 *  0. 물건과 원하는 갯수를 묶어주기
 *  1. 할인행사 물품을 앞에서부터 10개를 가져온다.
 *      1-1. 처음에는 removeFirst를 사용해서 반복하려 했으나 연산이 너무 많아서 인덱스 접근으로 변경
 *      1-2. 인덱스로 접근
 *  2. 물건의 갯수와 물품 10개가 맞는지 확인.
 *
 *  리턴값 : answer ( 초기값 0 ) -> 없을 경우 그대로 0 반환
 */

class `할인행사_김재원`{
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val products = want.toList().zip(number.toList())
        var index = 0
        while (index < discount.size -9){
            println(index)
            val temp = discount.slice(index until index+10)
            if (products.all { product -> temp.count { it == product.first } == product.second}){
                answer ++
            }
            index++
        }
        return answer
    }
}
