const val MAX = 2000
class Solution {
    fun solution(n: Int): Long {
        val dp = LongArray(MAX + 1)
        dp[0] = 1
        dp[1] = 1
        (2..MAX).forEach { i ->
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567
        }
        return dp[n]
    }
}