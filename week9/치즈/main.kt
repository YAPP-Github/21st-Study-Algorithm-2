import java.util.LinkedList
import java.util.Queue
import kotlin.properties.Delegates

lateinit var board: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)
var N by Delegates.notNull<Int>()
var M by Delegates.notNull<Int>()
var cheeseCount = 0
var remainCount = 0
var time = 0

fun main() = with(System.`in`.bufferedReader()) {
    readLine().split(" ").map { it.toInt() }.also {
        N = it[0]
        M = it[1]
    }
    board = Array(N) {
        readLine().split(" ").map {
            it.toInt().also { cheese ->
                if (cheese == 1) cheeseCount++
            }
        }.toIntArray()
    }
    while (cheeseCount > 0) {
        time++
        remainCount = cheeseCount
        bfs()
    }
    println(time)
    println(remainCount)
}

fun bfs() {
    val queue: Queue<IntArray> = LinkedList<IntArray>().apply { add(intArrayOf(0, 0)) }
    visited = Array(N) { BooleanArray(M) { false } }.apply { this[0][0] = true }
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        (0..3).forEach {
            val nX = cur[0] + dx[it]
            val nY = cur[1] + dy[it]
            if (nX in 0 until N && nY in 0 until M && visited[nX][nY].not()) {
                if (board[nX][nY] == 0) queue.add(intArrayOf(nX, nY))
                else {
                    cheeseCount--
                    board[nX][nY] = 0
                }
                visited[nX][nY] = true
            }
        }
    }
}

//어떻게 겉 공기에서 치즈를 도려내지? 라고 고민했는데, 너무 어렵게 생각했음.
//bfs의 동작을 잊고있었기 때문이 아닐까,,, 0,0은 어차피 공기이고 1이 나올때까지 찾기만 하면 그만인데 구멍때문에 너무 힘들게생각