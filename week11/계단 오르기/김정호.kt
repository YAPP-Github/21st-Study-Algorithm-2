import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stairs = IntArray(n + 1)
    val dp = IntArray(n + 1)

    repeat(n) {
        stairs[it + 1] = readLine().toInt()
    }

    dp.apply {
        this[1] = stairs[1]
        if(n >= 2) this[2] = stairs[1] + stairs[2]
    }

    for (i in 3 until n + 1) {
        dp[i] = max((dp[i - 2] + stairs[i]), (dp[i - 3] + stairs[i] + stairs[i - 1]))
    }

    println(dp.last())
}