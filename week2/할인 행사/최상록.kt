const val MemberTime = 10

class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        val hashMap = hashMapOf<String, Int>()
        want.forEachIndexed { index, s ->
            hashMap[s] = number[index]
        }
        var answer = 0
        repeat(discount.size - MemberTime + 1) { i ->
            val tempHashMap = hashMapOf<String, Int>().apply {
                putAll(hashMap)
            }
            discount.slice(i until i + MemberTime)
                    .forEach {
                        if (tempHashMap.containsKey(it)) {
                            tempHashMap[it] = tempHashMap[it]!! - 1
                        }
                    }
            val sum = tempHashMap.map { it.value }
                    .filter { it <= 0 }
                    .sumBy { 1 }
            if (sum == want.size) answer++
        }
        return answer
    }
}

//원하는 제품에 대해 카운트 해야하므로 hashMap 문제라고 파악
//시간복잡도는 O(N^2), 최대 1000개에 대해 1000 - 10 만큼 반복하면 됨

