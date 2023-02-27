import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashMap = HashMap<Char, Int?>()
        var start = 0
        var max = 0
        for(i in s.indices) {
            if (hashMap[s[i]] != null && hashMap[s[i]]!! >= start) {
                start = hashMap[s[i]]!! + 1
            }
            hashMap[s[i]] = i
            max = max(max, i - start + 1)
        }
        return max
    }
}

// 10000 * 5 = 50000
// 주어진 문자열에서 알파벳이 중복되지 않고 가장 길게 연속되는 문자열 일부를 반환하라