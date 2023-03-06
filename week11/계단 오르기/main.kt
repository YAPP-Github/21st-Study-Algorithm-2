import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val arr = IntArray(N + 1)
    val dp = IntArray(N + 1)
    val sb = StringBuilder()
    (1..N).forEach {
        arr[it] = readLine().toInt()
    }
    if (N == 1) {
        sb.append(arr[1])
    } else if (N == 2) {
        sb.append(arr[2] + arr[1])
    } else if (N == 3) {
        sb.append(max(arr[1] + arr[3], arr[2] + arr[3]))
    } else {
        dp[1] = arr[1];
        dp[2] = arr[2] + arr[1];
        dp[3] = max(arr[1] + arr[3], arr[2] + arr[3])
        (4..N).forEach {
            dp[it] = max(dp[it - 2] + arr[it], dp[it - 3] + arr[it - 1] + arr[it])
        }
        sb.append(dp[N])
    }
    print(sb.toString())
}
