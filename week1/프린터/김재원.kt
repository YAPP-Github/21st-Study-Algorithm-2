package week1.프린터

/**
 *  요청이 들어온 순서대로 -> 큐! 구현!
 */

class `프린터_김재원` {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 1
        var pointer = location
        val print = priorities.toMutableList()
        while (print.isNotEmpty()){
            val now = print.first()
            if (print.count{ now < it } >0){
                // 중요도가 높은게 1개라도 존재 하는 경우
                if (pointer == 0){
                    pointer = print.lastIndex
                }else{
                    pointer--
                }
                print.add(print.removeFirst())
            }else{
                //빼는 경우
                if (pointer == 0){
                    break
                }else{
                    print.removeFirst()
                    answer++
                    pointer--
                }
            }
        }
        return answer
    }
}

fun main(){
    println( `프린터_김재원`().solution(intArrayOf(2,1,3,2),2))
}