fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map(String::toInt)
    val coins = Array(n) {
        readLine().toInt()
    }
    val dp = IntArray(k + 1)
    dp[0] = 1
    (0 until n).forEach { i -> // 0 .. i 번째 가치의 동전까지 사용하면서
        (coins[i]..k).forEach { j -> // 합이 j가 되는 경우의 수, coins[i]원의 가치보단 앞서 있어야함
            dp[j] += dp[j - coins[i]] // 2원짜리 동전일 경우, j가 3일 때  2 + 1을 만족시킬 수 있음
        }
    }
    print(dp[k])

}