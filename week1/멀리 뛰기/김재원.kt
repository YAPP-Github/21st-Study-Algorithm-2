/**
 *  첫번째 아이디어 : 조합 + 순열
 *  두번째 아이디어 : dp (막대 자르기)를 기반 -> 이해가 안감
 *  세번째 아이디어 : 규칙찾기 ( 검색 조금,,, )
 *  n = 1 , 1
 *  n = 2 , 2
 *  n = 3,  3
 *  n = 4 , 5
 *  ... result[n] = result[n-1] + result[n-2]
 */


class `멀리뛰기_김재원` {
    fun solution(n: Int): Long {
        val arr = LongArray(n+1)
        arr[0] = 1
        arr[1] = 1
        if (n < 2) return arr[n]
        for (i in 2..n){
            arr[i] = (arr[i-1] + arr[i-2]) %1234567
        }

        return arr[n]
    }

}

fun main(){
    //`멀리뛰기_김재원`().solution(4)
    println( `멀리뛰기_김재원`().solution(3))
}