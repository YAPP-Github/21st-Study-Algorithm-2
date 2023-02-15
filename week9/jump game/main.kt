import java.lang.Integer.max

class Solution {
    fun canJump(nums: IntArray): Boolean {
        val N = nums.size
        var max = 0 //현재 갈 수 있는 최대 인덱스
        nums.forEachIndexed { index, num ->
            max = max(index + num, max) //현재 인덱스에서 현재 최대 거리만큼 간거랑, 이전 최대 거리랑 비교해서 갱신
            if(max >= N-1){ //만약 그게 N보다 크거나 같다면 도달
                return true
            }
            else if(max == index) return false //이전 최대거리와, 현재 인덱스가 같다면 max가 0이었다는 것이고 이는 더이상 갈 수 없음을 의미
        }
    }
}

fun main(){
    println(Solution().canJump(nums = intArrayOf(2,3,1,1,4)))
}

//일단 완전탐색 배제, 크기가 너무 큼
//그리디, dp 생각해봐야함
