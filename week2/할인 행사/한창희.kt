class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0

        val wantMap = mutableMapOf<String, Int>()
        val disMap = mutableMapOf<String, Int>()

        want.forEachIndexed { inx, value ->
            wantMap[value] = number[inx]
        }

        for (i in 0..9) {
            if (disMap[discount[i]] == null) disMap[discount[i]] = 1
            else disMap[discount[i]] = disMap[discount[i]]!! + 1
        }

        for (i in 9 until discount.size) {
            if (i != 9) {
                disMap[discount[i - 10]] = disMap[discount[i - 10]]!! - 1
                if (disMap[discount[i]] == null) disMap[discount[i]] = 1
                else disMap[discount[i]] = disMap[discount[i]]!! + 1
            }

            var isPossible = true
            wantMap.forEach { item, cnt ->
                if (disMap[item] == null || cnt != disMap[item]) {
                    isPossible = false
                }
            }

            if (isPossible) answer++
        }

        return answer
    }
}