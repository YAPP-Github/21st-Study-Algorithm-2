fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map(String::toInt)
    val dp = Array(n + 1) {
        IntArray(n + 1)
    }
    val sb = StringBuilder()
    val orgin = Array(n + 1) {
        IntArray(n + 1)
    }
    (1..n).forEach { i ->
        val line = readLine().split(" ").map(String::toInt)
        (1..n).forEach { j ->
            orgin[i][j] = line[j-1]
        }
    }

    //(0,0) ~ (i, j) 까지의 직사각형 합을 누적합으로 구하기
    for (i in 1..n) {
        for (j in 1..n) {
            dp[i][j] = orgin[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
        }
    }

    //누적합을 이용하여 해당 구간만 구하기
    repeat(m) {
        val (x1, y1, x2, y2) = readLine().split(" ").map(String::toInt)
        sb.appendLine(dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1])
    }
    print(sb)

}