/**
 * 1부터 elements 사이즈만큼 반복
 *    1. 앞에 n-1개를 맨 뒤로 붙여주기
 *    2. 앞에서부터 n개씩 가져와서 더해주기
 *    3. 맨 앞 제거하기
 *    1~3을 요소가 n보다 같거나 클때까지
 *   리턴값 : 중복을 제거하기 위한 Set 사용
 **/

class `연속_김재원` {
    fun solution(elements: IntArray): Int {
        val answer = mutableSetOf<Int>()

        for (i in 1..elements.size){
            val temp = elements.toMutableList()
            elements.take(i-1).forEach{temp.add(it)}
            while (temp.size >= i){
                answer.add(temp.take(i).sum())
                temp.removeFirst()
            }
        }
        return answer.size
    }
}

fun main(){
    println( `연속_김재원`().solution(intArrayOf(7,9,1,1,4)))
}