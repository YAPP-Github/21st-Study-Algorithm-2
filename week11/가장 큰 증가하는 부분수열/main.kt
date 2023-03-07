lateinit var seq: IntArray
lateinit var dp: IntArray //합이 가장 큰 증가하는 부분수열
fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    seq = readLine().split(" ").map(String::toInt).toIntArray()
    dp = IntArray(N)
    print(lis(N))
}
fun lis(n: Int): Int {
    dp[0] = seq[0]
    for (i in 1 until n) {
        dp[i] = seq[i]
        for (j in 0 until i) {
            //증가 수열일 때 부분합 갱신
            if (seq[i] > seq[j]) {
                dp[i] = Math.max(dp[j] + seq[i], dp[i])
            }
        }
    }
    return dp.maxOrNull() ?: 0
}

