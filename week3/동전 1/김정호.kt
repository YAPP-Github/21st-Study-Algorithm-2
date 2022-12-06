fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val coins = IntArray(n) { readLine().toInt() }
    val dp = IntArray(10001)

    dp[0] = 1

    for (i in coins.indices) {
        for (j in coins[i] .. k) {
            dp[j] += dp[j - coins[i]]
        }
    }

    println(dp[k])
}
