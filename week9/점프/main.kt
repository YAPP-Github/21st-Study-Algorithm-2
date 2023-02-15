import kotlin.math.max
import kotlin.properties.Delegates

lateinit var board: Array<IntArray>
lateinit var dp: Array<LongArray>
val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)
var N by Delegates.notNull<Int>()
var count = 0

fun main() = with(System.`in`.bufferedReader()) {
    N = readLine().toInt()
    board = Array(N) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    dp = Array(N) { //x, y에서 끝 점에 도달하는 경로의 수
        LongArray(N) { -1L }
    }
    println(dfs(0, 0))
}

fun dfs(i: Int, j: Int): Long {
    if (dp[i][j] != -1L) { //이미 저장되어 있다면 메모이제이션을 통해 제공
        return dp[i][j]
    }
    if (i == N - 1 && j == N - 1) { //결과에 도달했다면 1 추가
        return 1
    }
    dp[i][j] = 0 //0으로 초기화
    val nX = i + board[i][j]
    val nY = j + board[i][j]
    if (nX <= N - 1) {
        dp[i][j] = max(dp[i][j], dp[i][j] + dfs(i + board[i][j], j)) //끝점까지 도달하는 경로를 dp에 저장
    }
    if (nY <= N - 1) {
        dp[i][j] = max(dp[i][j], dp[i][j] + dfs(i, j + board[i][j])) //끝점까지 도달하는 경로를 dp에 저장
    }
    return dp[i][j] //dp 반환
}