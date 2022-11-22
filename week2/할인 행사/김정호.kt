class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer = 0

        for (i in 0..discount.size - 10) {
            val disList = discount.slice(i..i + 9)

            var flag = true

            for (j in want.indices) {
                val num = disList.count { it == want[j] }
                if (num < number[j]) {
                    flag = false
                    break
                }
            }

            if (flag) answer++
        }

        return answer
    }
}
